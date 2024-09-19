import { movieData2 } from '../model/MovieDataModel';
import { movieData1 } from '../model/MovieDataModel';
export class MovieRankViewModel{
  //加载 movieData1
  loadMovieRankDataSource1():any[]{
    return movieData1;
  }
  //加载 movieData2
  loadMovieRankDataSource2():any[]{
    return movieData2;
  }
}