export default class VideoBean {
  id: string;
  author: string //作者
  title: string; //视频标题
  desc: string //描述信息
  src: Resource; //视频链接
  shareCount: number; //分享次数
  likeCount: number; //点赞数
  isLike: boolean; //是否小红心
  commentCount: number; //评论数

  constructor(id: string, author: string, title: string, desc: string, src: Resource, shareCount: number, likeCount: number, isLike: boolean, commentCount: number) {
    this.id = id;
    this.author = author
    this.title = title;
    this.desc = desc
    this.src = src;
    this.shareCount = shareCount;
    this.likeCount = likeCount;
    this.isLike = isLike;
    this.commentCount = commentCount;
  }
}