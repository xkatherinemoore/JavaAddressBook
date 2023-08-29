public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        String firstName;
        String lastName;
        String phoneNumber;
        String emailAddress;

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

            int action = userInput.nextInt();
            System.out.println();

            switch(action) {
                //Add a contact
                case 1: 
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
                //Remove a contact    
                case 2: 
                    System.out.println("Enter the email address for the contact you would like to remove:");
                    emailAddress = userInput.nextLine();
                    addressBook.removeContact(emailAddress);
                    break;
                //Search for a specific contact
                case 3:
                    System.out.println("What would you like to search?");
                    System.out.println("1) First name");
                    System.out.println("2) Last name");
                    System.out.println("3) Phone number");
                    System.out.println("4) Email address");
                    int searchParameter = userInput.nextInt();
                    
                    //Invalid search parameter
                    if (searchParameter != 1 || searchParameter != 2 || searchParameter != 3 || searchParameter != 4) {
                        System.out.println();
                        System.out.println("Search parameter was not valid. Must be a number 1 - 4");
                        continue;
                    }

                    System.out.println("Enter search: ");
                    String searchQuery = userInput.nextLine();

                    addressBook.findContact(searchParameter, searchQuery);
                    break;
                //View all contacts 
                case 4: 
                    //No contacts in address book
                    if (addressBook.size() == 0) {
                        System.out.println("Your address book is currently empty.");
                        continue;
                    }
            }
        } while (action != 6);

    }
}
