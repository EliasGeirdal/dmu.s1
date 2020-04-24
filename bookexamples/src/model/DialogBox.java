package model;

import javax.swing.JOptionPane;

public class DialogBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String input = JOptionPane.showInputDialog("Enter price:");

		      double price = Double.parseDouble(input);
		      final double TAX_RATE = 8.5;
		      price = price * (1 + TAX_RATE / 100);
		      JOptionPane.showMessageDialog(null, "Price after tax: " + price);
*/
		
		
		String name = JOptionPane.showInputDialog("Why hello.. what is your name?");
		JOptionPane.showMessageDialog(null, "very good.." + " " + name + " " + "my name is Jonathan");
		String gender = JOptionPane.showInputDialog("What is your gender, if I may ask?");
		JOptionPane.showMessageDialog(null, "Very well");
		String age = JOptionPane.showInputDialog("What is your age?");
		JOptionPane.showMessageDialog(null, "oh you young" + " " + gender + " " + "My age is binary");
	}

}
