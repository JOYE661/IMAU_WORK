import CinemaBean from '../pages/bean/CinemaBean'
import ItemBean from '../pages/bean/ItemBean'
import MovieBean from '../pages/bean/MovieBean'
import ServiceCard from '../pages/bean/ServiceCard'
import VideoBean from '../pages/bean/VideoBean'
export class MainViewModel{

  getSwiperImages():Array<Resource>{
    let images:Array<Resource>=[
      $r('app.media.movie_banner1'),
      $r('app.media.movie_banner2'),
      $r('app.media.movie_banner3'),
      $r('app.media.movie_banner4')
    ]
    return images
  }

  getItemBeanData():Array<ItemBean>{
    let items:ItemBean[]=[
      new ItemBean('电影|影院',$r('app.media.icon_dianying')),
      new ItemBean('演出|玩乐',$r('app.media.icon_yanchu')),
      new ItemBean('演唱会',$r('app.media.icon_yanchanghui')),
      new ItemBean('脱口秀',$r('app.media.icon_tuokouxiu')),
      new ItemBean('密室',$r('app.media.icon_mishi')),
      new ItemBean('景点门票',$r('app.media.icon_jingdian')),
      new ItemBean('放映厅',$r('app.media.icon_bofang')),
      new ItemBean('剧集综艺',$r('app.media.icon_juji')),

    ]
    return items
  }

  getHotMovieBeanData():Array<MovieBean>{
    let movies:MovieBean[]=[
      new MovieBean('七夕',$r('app.media.movie1')),
      new MovieBean('世界晚安',$r('app.media.movie2')),
      new MovieBean('三十而已',$r('app.media.movie3')),
      new MovieBean('你该学习了',$r('app.media.movie4')),
      new MovieBean('节日快乐',$r('app.media.movie5')),

    ]
    return movies
  }

  getSwiperAdvImages():Array<Resource>{
    let advImages:Resource[]=[
      $r('app.media.adv1'),
      $r('app.media.adv2'),
      $r('app.media.adv3'),
      $r('app.media.adv4'),

    ]
    return advImages
  }

  getAllCinemas():Array<CinemaBean>{
    let cinemas:CinemaBean[]=[
    new CinemaBean(1, '万象影城','大朗店','大朗镇复康路229号',['退', '4k影厅'], 29.90),
    new CinemaBean(2, '万达影城','寮步店','寮步镇寮步路29号', ['改签','4k影厅'], 9.90),
    new CinemaBean(3, '青蛙影城','松山湖店', '松山湖新城路29号', ['改签', '巨幕厅'],19.90),
    new CinemaBean(4, '飞鹤影城','人民店','人民公社北京路229号', ['退','小吃', '4k影厅'],39.90),
    new CinemaBean(5, '万家喜影城','东城店', '东城区东方路129号', ['小吃', '券包'], 29.90),
    new CinemaBean(6, '熊猫影城','大学城店', '大学城宏光路2号', ['小吃', '4k影厅'],19.90),
    new CinemaBean(7, '万象影城','万象汇店', '大朗镇万汇路22号', ['退','爆米花', '8D'], 29.90),
    new CinemaBean(8, '万象影城','万象城店', '常平镇万象城29号', ['可乐续杯','4D'],9.90),
    new CinemaBean(9, '大雄影城','常平店','常平镇复康路22号', ['改签','4k影厅'], 59.90),
    new CinemaBean(10, '飞鹤影城','东坑店','东坑镇复康路29号',['退','3DMaX'], 29.90),
    new CinemaBean(11, '飞鹤影城','南城店','南城复康路9号',['退', '改签', '4k影厅'], 29.90),
    new CinemaBean(12, '万象影城','大朗店','大朗镇复康路129号',['改签', '影城卡','巨幕'],19.90),
    new CinemaBean(13, '万达影城','大朗店','大朗镇复康路129号',['退', '小吃'], 9.90),
    new CinemaBean(14, 'HelloKit影城', '人民店','大朗镇人民路29号',['小吃', '巨幕'], 39.90),
    new CinemaBean(15, '红太阳影城','松山湖店', '松山湖镇复康路22号',['影城卡','改签', '小吃'],29.90),
    new CinemaBean(16, '绿巨人影城','大朗店', '大朗镇复康路9号', ['退','4k影厅'], 19.90)
    ]
    return cinemas
  }

  getAllVideos():Array<VideoBean>{
    let videos:Array<VideoBean>=[
      new VideoBean('1','塔莎', '踏浪而来', '「踏浪而来，释放内心的澎湃！战胜恐惧，尽享自由！」在这个夏天，让海浪成为你的翅膀，一起迎接冲浪的挑战。感受那种在波浪上滑行的刺激与快感，释放你内心的激情与勇气。无论你是初学者还是经验丰富的冲浪爱好者，都将在这片碧海蓝天中找到你的乐趣。快来踏浪而来，挑战自我，创造属于你的浪漫瞬间吧！�‍ #踏浪而来#冲浪之旅', $rawfile('video1.mp4'),111,1231,true,123),
      new VideoBean('2','塔莎', '踏浪而来', '「踏浪而来，释放内心的澎湃！战胜恐惧，尽享自由！」在这个夏天，让海浪成为你的翅膀，一起迎接冲浪的挑战。感受那种在波浪上滑行的刺激与快感，释放你内心的激情与勇气。无论你是初学者还是经验丰富的冲浪爱好者，都将在这片碧海蓝天中找到你的乐趣。快来踏浪而来，挑战自我，创造属于你的浪漫瞬间吧！�‍ #踏浪而来#冲浪之旅', $rawfile('video2.mp4'),122, 1241, false, 234),
      new VideoBean('3','塔莎', '踏浪而来', '「踏浪而来，释放内心的澎湃！战胜恐惧，尽享自由！」在这个夏天，让海浪成为你的翅膀，一起迎接冲浪的挑战。感受那种在波浪上滑行的刺激与快感，释放你内心的激情与勇气。无论你是初学者还是经验丰富的冲浪爱好者，都将在这片碧海蓝天中找到你的乐趣。快来踏浪而来，挑战自我，创造属于你的浪漫瞬间吧！�‍ #踏浪而来#冲浪之旅', $rawfile('video3.mp4'),133, 234, true, 345),
      new VideoBean('4','塔莎', '踏浪而来', '「踏浪而来，释放内心的澎湃！战胜恐惧，尽享自由！」在这个夏天，让海浪成为你的翅膀，一起迎接冲浪的挑战。感受那种在波浪上滑行的刺激与快感，释放你内心的激情与勇气。无论你是初学者还是经验丰富的冲浪爱好者，都将在这片碧海蓝天中找到你的乐趣。快来踏浪而来，挑战自我，创造属于你的浪漫瞬间吧！�‍ #踏浪而来#冲浪之旅', $rawfile('video4.mp4'),144, 3456, false, 456),
    ]
    return videos;
  }

  getMyServiceCard(): Array<ServiceCard> {
    let serviceCards: Array<ServiceCard> = [
      new ServiceCard('省钱月卡', $r('app.media.servicecard')),
      new ServiceCard('0 元观影', $r('app.media.servicecard1')),
      new ServiceCard('周边商城', $r('app.media.servicecard2')),
      new ServiceCard('蛙币捐赠', $r('app.media.servicecard3')),
      new ServiceCard('连连看', $r('app.media.servicecard4')),
      new ServiceCard('处处省', $r('app.media.servicecard5'))
    ]
    return serviceCards
  }
}

export default new MainViewModel()