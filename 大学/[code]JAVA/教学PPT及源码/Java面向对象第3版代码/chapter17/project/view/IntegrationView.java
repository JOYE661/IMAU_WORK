package project.view;
import java.awt.*;
import javax.swing.*;
public class IntegrationView extends JFrame{
    JTabbedPane tabbedPane; //��ѡ��������и�����ͼ
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
        new JTabbedPane(JTabbedPane.LEFT);//������࣬Ĭ����JTabbedPane.TOP
        addWordView = new AddWordView();
        updateWordView = new UpdateWordView();
        delWordView = new DelWordView();
        oneWordView = new  QueryOneWordView();
        queryAllWordView = new QueryAllWordView();
        queryRandomView = new RandomQueryView();
        tabbedPane.add("��ӵ���",addWordView); 
        tabbedPane.add("�޸ĵ���",updateWordView); 
        tabbedPane.add("ɾ������",delWordView);
        tabbedPane.add("��ѯһ������",oneWordView); 
        tabbedPane.add("���ȫ������",queryAllWordView);
        tabbedPane.add("����鿴����",queryRandomView); 
        tabbedPane.validate();
        add(tabbedPane,BorderLayout.CENTER); 
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
