package U2023Test;

/*
ע�⣺
�����ļ����д���Test.java���ļ����ó����ǲ������ģ�����begin��end����д����ʵ��Ҫ��Ĺ��ܡ�
����ɾ��ע���л�Ķ��������ݣ�����ʱ���ø���ԭ���ļ�����
��Ŀ��������������������������±�����
��д������ڿ����ļ����±�����ԡ�
��ĿҪ�󣺶���γ��࣬������Ա�����γ���String name��ѡ������ String[] students��
ѡ������int numOfStudents����Ƴ�Ա����ʵ���ÿγ�������γ̶���
��ѡ�����������ѧ����ɾ ��ѧ���ʹ�ӡѡ��������ʹ�ò�����Test�еĴ�������������С�
*/

public class test1{
	public static void main(String[] args){
		Course c=new Course("Java");
		c.addStudent("zhangsan");
		c.addStudent("lisi");
		c.addStudent("wang");
		c.dropStudent("lisi");
		c.print();
	}	
}

	/****************begin***************/
class Course{
	private String name;
	private String[] students=new String[10];
	private int numOfStudents;
	public Course(String name){this.name=name;}
	public void addStudent(String s){students[numOfStudents]=s;numOfStudents++;}
	public void dropStudent(String s){
		int i=0;
		while(i<numOfStudents){
			if(s.equals(students[i])){break;}
			i++;
		}
		while(i<numOfStudents){
			students[i]=students[i+1];
			i++;
		}
		numOfStudents--;
	}
	public void print(){
		for(int i=0;i<numOfStudents;i++){
			System.out.println(students[i]);
		}
	}
}	



	/****************end***************/

