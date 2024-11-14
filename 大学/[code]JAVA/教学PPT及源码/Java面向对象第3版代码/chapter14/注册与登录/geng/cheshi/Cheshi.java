package geng.cheshi;
import geng.model.*;
import geng.handle.*;
import java.sql.*;
public class Cheshi {
   public static void main(String args[]) {
      Register user = new Register();
      user.setID("moonjavasun");
      user.setPassword("1234567");
      user.setBirth("1979-12-10");
      HandleRegister handleRegister = new HandleRegister();
      handleRegister.writeRegisterModel(user); //注册一个用户
      Login login = new Login();             
      login.setID("moonjavasun");
      login.setPassword("1234567");
      HandleLogin  handleLogin = new HandleLogin();
      login = handleLogin.queryVerify(login);  //该用户登录
      if(login.getLoginSuccess()==true) {
         System.out.println("登录成功了！");
      }
   }
}