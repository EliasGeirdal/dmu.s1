package model;

public class PersonApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person("Peter ", "highwayroad nr 3 ", 35000);
		p1.setPreviousFirms("Microsoft, " + "IBM, " + "Capgemini, " + "Infosys");
		p1.printPerson();

		String tekst = Math.PI + "";
		double pi = tekst.indexOf("2147843647");
		System.out.println(tekst);

	}

}
