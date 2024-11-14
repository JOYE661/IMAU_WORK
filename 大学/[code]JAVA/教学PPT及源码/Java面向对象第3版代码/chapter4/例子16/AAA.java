class AAA {
   private int money;
    private int getMoney() {
        return money;
    }
    public static void main(String args[]) {
         AAA  exa=new AAA();                 //对象exa在AAA类中
         exa.money=3000;
         int m=exa.getMoney();
         System.out.println("money="+m);
    }
}
