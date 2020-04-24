package child;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(4, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old
		Child c3 = new Child(15, false);// girl 2 years old

		System.out.println("Et barn på " + c1.getAge() + " skal gå i" + " " + c1.institution());
		System.out.println("Et barn på " + c2.getAge() + " skal gå i" + " " + c2.institution());
		System.out.println("Et barn på " + c3.getAge() + " skal gå i" + " " + c3.institution());
		System.out.println(c1.getGender());
		System.out.println(c2.getGender());
		System.out.println(c3.getGender());
		System.out.println(c3.team());
		System.out.println(c3.team());
		System.out.println(c3.team());
		System.out.println(c3.team());
		

	}

}
