import { MovieBean } from '../common/been/MovieBeen';
import { ListHeaderComponent } from '../view/ListHeaderComponent'
import { ListItemComponent } from '../view/ListItemComponent'
import { TitleComponent } from '../view/TitleComponent'
import { MovieRankViewModel } from '../viewmodel/MovieRankViewModel';
let movieRankModel: MovieRankViewModel = new MovieRankViewModel()
@Entry
@Component
struct Index {
  @State dataScoure1: MovieBean[] =[
    // {'id':'1','movieName':'满江红','tickets':'54321'},
    // {'id':'2','movieName':'阿凡达','tickets':'44321'},
    // {'id':'3','movieName':'你好，李焕英','tickets':'34321'},
    // {'id':'4','movieName':'火星救援','tickets':'24321'},
    // {'id':'5','movieName':'星球大战','tickets':'14321'}
  ];
  @State dataScoure2: MovieBean[] =[];
  @State isUpdataDataSource:boolean = true;

  @Builder MovieRankList(){
    Column(){
      List(){
        ForEach(this.isUpdataDataSource?this.dataScoure1:this.dataScoure2,(item,index) =>{
          ListItem(){
            ListItemComponent({index:index+1,
              movieName:item.movieName,
              tickets:item.tickets})
          }
        },item =>JSON.stringify(item))
      }
      .width('100%')
      .height('70%')
      .divider({strokeWidth:1})
    }.padding(15)
    .borderRadius(15)
    .alignItems(HorizontalAlign.Center)
    .backgroundColor(Color.White)
    .width('90%')
  }
  aboutToAppear(){
    this.dataScoure1 = movieRankModel.loadMovieRankDataSource1();
    this.dataScoure2 = movieRankModel.loadMovieRankDataSource2();
  }
  build() {
      Column() {
        TitleComponent({isUpdataDataSource:$isUpdataDataSource})
        ListHeaderComponent()
          .margin({top:10,bottom:10})
        //ListItemComponent()
        this.MovieRankList()
      }.width('100%').height('100%').backgroundColor('#ffa3b8cd')
    }
}