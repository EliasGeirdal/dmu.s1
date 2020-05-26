package controller;

import java.io.FileNotFoundException;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Controller.createSomeObjects();
		System.out.println(Controller.getParkeringshuse());
		System.out.println(Controller.getParkeringshuse().get(0).getParkeringspladser());
		System.out.println(Controller.getBiler());

		Controller.writeOptagnePladser(Controller.getParkeringshuse().get(0), "src\\controller\\test.txt");
	}

}
