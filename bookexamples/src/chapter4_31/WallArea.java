package chapter4_31;

import java.util.Scanner;

public class WallArea {
	
	private int area;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		      // Declare a scanner
		      
		      Scanner in = new Scanner(System.in);
		  
		      final int WindowArea = 2 * 3;

		      // Prompt for and read the width and height
		      // and the number of windows
		      System.out.print("Please enter height of the wall: ");
		      int height = in.nextInt();
		      System.out.print("Please enter width of the wall: ");
		      int width = in.nextInt();
		    
		      System.out.print("Please enter the number of windows on the wall: ");
		      int windowsCount = in.nextInt();

		      // Compute the area of the wall without the windows
		      double area = (height * width) - (WindowArea * windowsCount);
		      System.out.println("The area of the wall is: " + area);
		      
		      // Close scanner
		      in.close();

	}

}
