package opgave3;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "jubiiiiee";
		System.out.println(MainApp.ifKAmountOfChar(s, 2));
		System.out.println(MainApp.ifKAmountOfChar(s, 3));
		System.out.println(MainApp.ifKAmountOfChar(s, 4));
		System.out.println(MainApp.ifKAmountOfChar(s, 5));
	}

	/**
	 * returns true if there is k amount of characters in s.
	 * 
	 * @param s String
	 * @param k how many adjacent characters to check for.
	 * @return
	 */
	public static boolean ifKAmountOfChar(String s, int k) {
		int count = 1;
		boolean charGroup = false;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				// create new chargroup
				if (!charGroup) {
					count++;
					charGroup = true;
				} else if (charGroup) {
					count++;
				}
			} else
				charGroup = false;
		}
		if (count == k) {
			return true;
		}
		return false;
	}

//	public static boolean isAdjacentLength(String s, int k) {
//		int i = 0;
//		while (i <= s.length() - k) {
//			if (match(k, s, i)) {
//				return true;
//			}
//			i++;
//		}
//		return false;
//	}
//
//	private static boolean match(int k, String sm, int i) {
//		int j = 1;
//		int count = 1;
//		boolean found = false;
//		while (j < sm.length() - i && !found) {
//			if (sm.charAt(i) == sm.charAt(i + j)) {
//				count++;
//			}
//			j++;
//		}
//		if (count != k) {
//			return false;
//		}
//		return true;
//	}
}
