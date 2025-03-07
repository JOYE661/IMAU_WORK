from rest_framework import serializers
from rest_framework.serializers import ModelSerializer
from . import models

class GuanliModelSerializers(ModelSerializer):
    """管理员信息模型序列化器"""
    username = serializers.CharField(read_only=True)

    class Meta:
        model = models.Guanli
        fields = '__all__'

class PublishSerializer(serializers.ModelSerializer):
    class Meta:
        model=models.Publish
        fields = "__all__"

class AuthorSerializer(serializers.ModelSerializer):
    class Meta:
        model=models.Author
        fields = "__all__"

class BookInfoModelSerializermodel(serializers.ModelSerializer):
    # 使用PublishSerializer作为publish字段的嵌套序列化器
    publish = PublishSerializer(read_only=True)
    # 使用主键字段类型 并且将publish_id设置为"只写"，也就是读取的时候不会返回！
    publish_id = serializers.PrimaryKeyRelatedField(queryset=models.Publish.objects.all(), source='publish',
                                                    write_only=True)

    # 使用AuthorSerializer作为author字段的嵌套序列化器
    authors = AuthorSerializer(read_only=True, many=True)
    # 使用主键字段类型 并且将author_id设置为"只写"，也就是读取的时候不会返回！
    authors_id = serializers.PrimaryKeyRelatedField(queryset=models.Author.objects.all(), source='authors',
                                                    write_only=True, many=True)

    class Meta:
        model = models.Book
        # fields = ['id', 'title', 'price', 'pub_date', 'bread', 'bcomment', 'publish_id', 'publish', 'authors',
        #           'authors_id']
        fields = "__all__"
        # depth = 1