package opgave_3;

import java.time.LocalDate;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product iphone = new Product(1, "iPhone 11", 7000.0);
		Product speakers = new Product(2, "Creative Boom Speaker", 5000.0);
		Product book = new Product(3, "Big Java: Early Objects", 500.0);
		Product headset = new Product(4, "BOSE QC 35", 2500.0);
		Product harddrive = new Product(5, "TOSHIBA 500 GB", 750.0);
		System.out.printf("%s%n", iphone);

		Customer james = new Customer("James", LocalDate.of(1997, 7, 2));
		Customer caroline = new Customer("Caroline", LocalDate.of(1996, 12, 20));
		System.out.printf("%n%s%n", james);

		Discount discount1 = new PercentDiscount(50);
		Discount discount2 = new FixedDiscount(1000, 1000);
		Discount discount3 = new AgeDiscount(50);
		System.out.printf("%n%s%n", discount1);
		james.setDiscount(discount2);
		System.out.printf("%n%s%n", james);

		// James' orders
		Order order1 = new Order(1);
		order1.createOrderLine(1, iphone);
		order1.createOrderLine(1, speakers);
		System.out.printf("%n%s%n" + "Order price: %.2f kr.%n", order1, order1.getOrderPrice());

		Order order2 = new Order(2);
		order2.createOrderLine(1, book);
		order2.createOrderLine(1, headset);

		// Carolines orders
		Order order3 = new Order(3);
		order3.createOrderLine(1, book);
		order3.createOrderLine(1, harddrive);
		System.out.printf("%n%s%n" + "Order price: %.2f kr.%n", order3, order3.getOrderPrice());

		Order order4 = new Order(4);
		order4.createOrderLine(1, iphone);
		order4.createOrderLine(1, headset);

		Order order5 = new Order(5);
		order5.createOrderLine(1, speakers);
		order5.createOrderLine(1, book);

		Order order6 = new Order(6);
		order6.createOrderLine(1, harddrive);
		order6.createOrderLine(2, iphone);

		// Add orders to James
		james.addOrder(order1);
		james.addOrder(order2);
		System.out.printf("%nJames total price: %.2f kr.%n", james.totalBuy());
		System.out.printf("%nJames total price with discount: %.2f kr.%n", james.totalBuyWithDiscount());

		// Add orders to Caroline
		caroline.addOrder(order3);
		caroline.addOrder(order4);
		caroline.addOrder(order5);
		caroline.addOrder(order6);
		System.out.printf("%nCaroline total price: %.2f kr.%n", caroline.totalBuy());
	}

}
