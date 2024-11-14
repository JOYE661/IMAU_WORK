public class AdvertisementBoard {
   Advertisement adver ;
   public void setAdvertisement(Advertisement adver){
       this.adver = adver;
   }
   public void show() {
       if(adver != null){
          System.out.println("广告牌显示"+adver.getCorpName()+"公司的广告词：");
          adver.showAdvertisement();
       }
       else {
           System.out.println("广告牌无广告");
       }
   }
}
