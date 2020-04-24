package opgaver;

public class Person {

	private String name;
	private String title;
	private boolean senior;

	public Person(String title, String name, boolean senior) {
		this.name = name;
		this.title = title;
		this.senior = senior;
	}

	@Override
	public String toString() {
		String s = title + " " + name;
		if (senior)
			s = s + " (Senior)";
		return s;
	}

}
