public class Student extends SchoolPerson{
	public static void main(String[] args) {
		Student stu=new Student();
	}
	public Student() {
		System.out.println("Student()");
	}
}
class SchoolPerson extends Person{
	public SchoolPerson() {
		this("123");
		System.out.println("SchoolPerson()");
	}
	public SchoolPerson(String s) {
		System.out.println("SchoolPerson(String s)");
	}
}
class Person{
	public Person() {
		System.out.println("person()");
	}
}
