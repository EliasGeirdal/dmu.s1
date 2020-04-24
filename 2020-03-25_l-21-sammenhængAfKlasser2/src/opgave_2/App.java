package opgave_2;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("Jens", 20);

		Person p2 = new Person("Ole", 25);
		Person p3 = new Person("Jørgen", 28);
		Person p4 = new Person("Mads", 30);
		Person p5 = new Person("Rolf", 40);

		Gift guitar = new Gift("Guitar", p2);
		Gift cykel = new Gift("Cykel", p3);
		Gift sokker = new Gift("Sokker", p4);

		sokker.setGiver(p5);

		guitar.setPrice(5000);
		cykel.setPrice(10000);
		sokker.setPrice(100);

		p1.addGift(guitar);
		p1.addGift(cykel);
		p1.addGift(sokker);

		System.out.println(p1);
		System.out.println("total gift value: " + p1.totalGiftValue());

		System.out.println("\nGivers: ");
		for (Person giver : p1.getGiftGivers()) {
//			System.out.println(giver.getGiftGivers());
			System.out.println(giver);
		}
	}
}
