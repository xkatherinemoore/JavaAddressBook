
public class Contact {
	//Instance Variables
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	//Constructors
	public Contact() {}
	public Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	//Getters & Setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	//toString()
	@Override
	public String toString() {
		System.out.println("**********");
		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
		System.out.println("Phone number: " + phoneNumber);
		System.out.println("Email: " + emailAddress);
		System.out.println("**********");
		System.out.println();
		return "Contact";
	}
}
