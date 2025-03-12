from rest_framework import serializers
from .models import *

class StudentSerializergj(serializers.Serializer):
    # 这里的name必须和数据库中字段值相同 还有一种如果执行source就可以不同
    # source 代表我序列化器用 names 但是数据库源字段是 name
    # names = serializers.CharField(source='name')
    id = serializers.IntegerField(read_only=True)
    name = serializers.CharField()
    age = serializers.IntegerField()
    class_null = serializers.CharField()

    def create(self, validated_data):
        # 插入 生成学生对象
        instance = Student.objects.create(**validated_data)
        return instance

    def update(self, instance, validated_data):
        # 插入 生成学生对象
        instance.name = validated_data.get("name", instance.name)
        instance.age = validated_data.get("age", instance.age)
        instance.class_null = validated_data.get("class_null", instance.class_null)
        # instance.update(**validated_data)
        instance.save()
        return instance