package project.test;
import java.sql.*;
import project.data.*;
public class AppTest {
   public static void main(String []args) {
      new CreateDatabaseAndTable();  //�������ݿ�ͱ�
      Word word = new Word();
      String [][] a = { {"boy","�к�"},{"girl","Ů��"},
                        {"sun","̫��"},{"moon","����"},
                        {"book","�鼮"},{"water","ˮ"}
                      };
      AddWord addWord = new AddWord();
      for(int i=0;i<a.length;i++){
          word.setEnglishWord(a[i][0]);
          word.setMeaning(a[i][1]);
          addWord.insertWord(word);
      }
      QueryOneWord q = new QueryOneWord();
      word.setEnglishWord("boy");
      Word re =q.queryOneWord(word);
      System.out.println("��ѯ����һ������:"); 
      System.out.printf("%-10s",re.getEnglishWord());
      System.out.printf("%-10s\n",re.getMeaning());
      QueryAllWord query = new QueryAllWord();
      Word [] result =query.queryAllWord();
      System.out.println("ȫ������:"); 
      output(result);
      RandomQueryWord random = new RandomQueryWord();
      random.setCount(3); //�����ȡ3������
      result = random.randomQueryWord();
      System.out.println("�����ȡ"+random.getCount()+"������:"); 
      output(result);
      UpdateWord update = new UpdateWord();
      word.setEnglishWord("book");
      word.setMeaning("n.�鼮�����ʲ������ᣬ������ vt.Ԥ�����Ǽ�");
      update.updateWord(word);
      DelWord del = new DelWord();
      word.setEnglishWord("boy");
      del.delWord(word);
      word.setEnglishWord("girl");
      del.delWord(word);
      System.out.println("���¡�ɾ��������:"); 
      query = new QueryAllWord();
      result =query.queryAllWord();
      output(result);
   }
   static void output(Word [] result){
      for(int i=0;i<result.length;i++){
          System.out.printf("%-10s",result[i].getEnglishWord());
          System.out.printf("%-10s",result[i].getMeaning());
          System.out.println();   
      }
   }
}
