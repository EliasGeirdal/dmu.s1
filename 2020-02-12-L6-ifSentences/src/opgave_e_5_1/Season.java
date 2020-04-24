package opgave_e_5_1;

import java.util.Scanner;

public class Season {

	// Instance variables:

	private int day;
	private int month;
	private String season;

	// Constructor:
	public Season() {

	}

	// Method:

	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	// Method to set the day and call the day: setDay / getDay.
	public void setDay(int day) {
		this.day = day;
	}

	public int getDay() {
		if (day > 31)
			System.out.println("Error: hit maximum capacity of \"days\" ");
		return day;
	}

	// Method to call the season: getSeason().
	public String getSeason() {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter month: ");
		int month = in.nextInt();

		System.out.print("Enter day: ");
		int day = in.nextInt();
		
		// every third month changes season.

		if (month == 1 || month == 2 || month == 3)
			season = "Winter";
		else if (month == 4 || month == 5 || month == 6)
			season = "Spring";
		else if (month == 7 || month == 8 || month == 9)
			season = "Summer";
		else if (month == 10 || month == 11 || month == 12)
			season = "Fall";
		else
			System.out.println("There are only 12 months.");

		// change season after 21st of last month in every season.
		if (month % 3 == 0 && day >= 21) {
			if (season == ("Winter"))
				season = "Spring";
			else if (season == ("Spring"))
				season = "Summer";
			else if (season == ("Summer"))
				season = "Fall";
			else if (season == ("Fall"))
				season = "Winter";
		}
		return "The current season is: " + season;

	}
}
