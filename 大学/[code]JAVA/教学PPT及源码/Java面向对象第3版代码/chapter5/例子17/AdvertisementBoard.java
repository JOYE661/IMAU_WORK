public class AdvertisementBoard {
   Advertisement adver ;
   public void setAdvertisement(Advertisement adver){
       this.adver = adver;
   }
   public void show() {
       if(adver != null){
          System.out.println("�������ʾ"+adver.getCorpName()+"��˾�Ĺ��ʣ�");
          adver.showAdvertisement();
       }
       else {
           System.out.println("������޹��");
       }
   }
}
