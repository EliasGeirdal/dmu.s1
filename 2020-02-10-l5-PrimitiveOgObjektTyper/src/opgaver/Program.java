package opgaver;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ord1 = "Datamatiker";
		String ord2 = "Uddannelsen";
		String ord3 = ord1 + " " + "uddannselsen";
		
		
		// Convert to upper acse letters:
		String ord1UpperCase = ord1.toUpperCase();
		
		// Convert to lower case letters:
		String ord2LowerCase = ord2.toLowerCase();
		
		// Calculate length of word
		int lengthOf3 = ord3.length();
		int lengthOf2 = ord2.length();
		
		// Calculate half length 
		String ord2LastEnd = ord2.substring(lengthOf2/2);
		
		
		System.out.println(ord1UpperCase);
		System.out.println(ord2LowerCase);
		System.out.println(ord1 + " " + ord2);
		System.out.println(ord3);
		System.out.println(lengthOf3);
		System.out.println(ord3.substring(0, 7));
		System.out.println(ord2.substring(3, 7));
		System.out.println(ord2LastEnd);
		
	}

}
