package project.view;
import java.awt.*;
import javax.swing.*;
public class IntegrationView extends JFrame{
    JTabbedPane tabbedPane; //用选项卡集成下列各个视图
    AddWordView  addWordView;
    UpdateWordView updateWordView;
    DelWordView delWordView;
    QueryOneWordView oneWordView;
    QueryAllWordView  queryAllWordView;
    RandomQueryView queryRandomView;
    public IntegrationView(){
        setBounds(100,100,1200,560);
        setVisible(true);
        tabbedPane=
        new JTabbedPane(JTabbedPane.LEFT);//卡在左侧，默认是JTabbedPane.TOP
        addWordView = new AddWordView();
        updateWordView = new UpdateWordView();
        delWordView = new DelWordView();
        oneWordView = new  QueryOneWordView();
        queryAllWordView = new QueryAllWordView();
        queryRandomView = new RandomQueryView();
        tabbedPane.add("添加单词",addWordView); 
        tabbedPane.add("修改单词",updateWordView); 
        tabbedPane.add("删除单词",delWordView);
        tabbedPane.add("查询一个单词",oneWordView); 
        tabbedPane.add("浏览全部单词",queryAllWordView);
        tabbedPane.add("随机查看单词",queryRandomView); 
        tabbedPane.validate();
        add(tabbedPane,BorderLayout.CENTER); 
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
