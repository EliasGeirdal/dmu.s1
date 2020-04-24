package opgaver;

public class Name {
	
	// Instance variables describing first name, middle name, last name etc.
	private String firstname;
	private String middlename;
	private String lastname;
	
	/** Constructor: The name needs a first name, middle name, last name etc.
	*@param firstname first name of the name.
	*@param middlename middle name of the name.
	*@param lastname last name of the name.
	*/
	public Name(String firstname, String middlename, String lastname) {
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
	}
	
	// The name's first name is set by the setFirstName method.
	// The name's first name is called by getFirstName method.
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getFirstName() {
		return firstname;
	}
	
	// The name's middle name is set by the setFirstName method.
    // The name's middle name is called by getFirstName method.
	public void setMiddleName(String middlename) {
		this.middlename = middlename;
	}
	public String getMiddleName() {
		return middlename;
	}
	
	// The name's last name is set by the setFirstName method.
	// The name's last name is called by getFirstName method.
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getLastName() {
		return lastname;
	}
	
	// Collect all three names into one:	
	// The names initials is called by getInit metoden.
	public String getInit() {
		String initials = firstname.substring(0,1) + middlename.substring(0,1) + lastname.substring(0,1);
		return initials;
	}
	
	//Collect two capital characters from first name, amount of characters of middle name (displayed in int), two last characters of last name.
	// The names username is called by getUsername method.
	public String getUsername() {
		String username = firstname.toUpperCase().substring(0,3) + middlename.length() + lastname.substring(lastname.length()-2);
		return username;
	}
	
	
}
