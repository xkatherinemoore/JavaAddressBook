import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		String firstName;
		String lastName;
		String phoneNumber;
		String emailAddress;
		int action = 0;

		System.out.println("ADDRESS BOOK:");

		do {

			System.out.println();
			System.out.println("Please choose which action you would like to perform:");
			System.out.println("1) Add a contact");
			System.out.println("2) Remove a contact");
			System.out.println("3) Search for a specific contact");
			System.out.println("4) View all contacts");
			System.out.println("5) Delete all contacts");
			System.out.println("6) Quit");

			String stringAction = userInput.nextLine();
			action = Integer.parseInt(stringAction);
			System.out.println();

			switch (action) {
			// Add a contact
			case 1:
				System.out.println("Add a new contact:");
				System.out.println("First name: ");
				firstName = userInput.nextLine();
				System.out.println("Last name: ");
				lastName = userInput.nextLine();
				System.out.println("Phone Number: ");
				phoneNumber = userInput.nextLine();
				System.out.println("Email address: ");
				emailAddress = userInput.nextLine();

				Contact newContact = new Contact(firstName, lastName, phoneNumber, emailAddress);
				addressBook.addContact(newContact);
				break;
			// Remove a contact
			case 2:
				System.out.println("Enter the email address for the contact you would like to remove:");
				emailAddress = userInput.nextLine();
				addressBook.removeContact(emailAddress);
				break;
			// Search for a specific contact
			case 3:
				System.out.println("What would you like to search?");
				System.out.println("1) First name");
				System.out.println("2) Last name");
				System.out.println("3) Phone number");
				System.out.println("4) Email address");
				
				String searchParameterString = userInput.nextLine();
				if (searchParameterString.equals("1") || searchParameterString.equals("2") || searchParameterString.equals("3") || searchParameterString.equals("4")) {
					int searchParameter = Integer.parseInt(searchParameterString);
					
					System.out.println("Enter search: ");
					String searchQuery = userInput.nextLine();

					addressBook.findContact(searchParameter, searchQuery);
					
				} else {
					System.out.println("Search parameter was invalid.");
					continue;
				}
				
				break;
				
			// View all contacts
			case 4:
				// No contacts in address book
				if (addressBook.getSize() == 0) {
					System.out.println("Your address book is currently empty.");
					continue;
				} else {
					addressBook.seeAllContacts();
				}
				break;
			// Delete all contacts
			case 5:
				System.out.println("Are you sure you would like to delete all contacts? Y/N");
				String confirmDelete = userInput.nextLine();
				if (confirmDelete.equals("y") || confirmDelete.equals("Y") || confirmDelete.equals("yes") || confirmDelete.equals("Yes")) {
					addressBook.removeAllContacts();
					System.out.println("All contacts successfully deleted");
				} else {
					System.out.println("No contacts were deleted.");
				}
				break;
			// Quit program
			case 6:
				break;
			}
		} while (action != 6);

	}

}
