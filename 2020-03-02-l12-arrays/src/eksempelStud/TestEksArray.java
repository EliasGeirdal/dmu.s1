package eksempelStud;

public class TestEksArray {

	public static void main(String[] args) {
		
		EksempelArray eksArray = new EksempelArray();
		
		int[] tal = {2,7,8,4,5,66,7,89,34};
		
		System.out.println(eksArray.sum(tal));
		System.out.println(eksArray.max(tal));
		
		Person p1 = new Person("Ulla", 33);
		Person p2 = new Person("Pia", 99);
		Person p3 = new Person("Bo", 76);
		Person p4 = new Person("Kim", 45);
		
		Person[] personer = new Person[4];
		
		personer[0] = p1;
		personer[1] = p2;
		personer[2] = p3;
		personer[3] = p4;
		
		System.out.println(eksArray.maxAlder(personer));
	}
}
