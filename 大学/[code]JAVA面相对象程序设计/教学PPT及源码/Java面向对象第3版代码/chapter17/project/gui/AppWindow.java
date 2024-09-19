package project.gui;
import project.view.IntegrationView;
import project.data.CreateDatabaseAndTable;
public class AppWindow {
   public static void main(String [] args) {
      new CreateDatabaseAndTable();
      IntegrationView win = new IntegrationView(); 
   }
}
