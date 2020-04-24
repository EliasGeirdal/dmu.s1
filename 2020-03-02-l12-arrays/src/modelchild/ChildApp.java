package modelchild;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(5, true);// boy 4 years old
		Child c2 = new Child(7, false);// girl 2 years old
		Child c3 = new Child(10, false);// girl 2 years old
		Child c4 = new Child(6, false);// girl 2 years old
		Child c5 = new Child(3, true);// girl 2 years old
		Child c6 = new Child(4, false);// girl 2 years old
		Child c7 = new Child(11, true);// girl 2 years old
		Child c8 = new Child(8, false);// girl 2 years old

		System.out.println("Et barn på " + c1.getAge());
		double[] weight = { 4.2, 9.3, 12.4, 17.5, 23.2, 25.3, 28.6, 30.4, 33.9, 35.1, 37.3 };
		c1.setWeight(weight);
		System.out.println(c1.getWeight(5));
		System.out.println(c1.getIncrease());

		Institution i = new Institution("sted", "stedet nr 5");
		i.addChild(c1);
		i.addChild(c2);
		i.addChild(c3);
		i.addChild(c4);
		i.addChild(c5);
		i.addChild(c6);
		i.addChild(c7);
		i.addChild(c8);
		System.out.println("Average age of children: " + i.averageAge());
		System.out.println("Number of girls: " + i.numberOfGirls());
		System.out.println("Number of boys: " + i.numberOfBoys());
	}

}
