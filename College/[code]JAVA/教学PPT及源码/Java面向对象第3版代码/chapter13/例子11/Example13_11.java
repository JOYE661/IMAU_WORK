import java.util.*; 
class Student{
    String name;
    int score;
    Student(String name,int score){
       this.name=name;
       this.score=score;
    }
}
public class Example13_11{
    public static void main(String args[]){
        Student zh=new Student("����",76),
                wa=new Student("����",88),
                li=new Student("����",97);
        HashSet<Student> set=new HashSet<Student>();
        HashSet<Student> subset=new HashSet<Student>();
        set.add(zh); 
        set.add(wa);
        set.add(li);
        subset.add(wa);
        subset.add(li); 
        if(set.contains(wa)){
           System.out.println("����set�к���:"+wa.name);
        }
        if(set.containsAll(subset)){
           System.out.println("����set��������subset");
        }
        int number=subset.size();
        System.out.println("����subset����"+number+"��Ԫ��:");
        Object s[]=subset.toArray();
        for(int i=0;i<s.length;i++){
           System.out.printf("����:%s,����:%d\n",((Student)s[i]).name,((Student)s[i]).score);
        }
        number=set.size();
        System.out.println("����set����"+number+"��Ԫ��:");
        Iterator<Student> iter=set.iterator();
        while(iter.hasNext()){
           Student te = iter.next();
           System.out.printf("����:%s,����:%d\n",te.name,te.score);
        }
    }
}
