public class AddressBook {
    private List<Contact> addressBook;
    
    public AddressBook() {
        addressBook = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        this.addressBook.add(contact);
        System.out.println("Adding contact...");
        System.out.println(contact.toString());
        System.out.println("Contact successfully added!");
        
    }

    public void removeContact(String emailAddress) {
        for(Contact storedContact : this.addressBook) {
            if(storedContact.getEmailAddress() == emailAddress) {
                this.addressBook.remove(storedContact);
                System.out.println("Contact successfully removed");
            } else {
                System.out.println("The entered email address could not be found in your contacts");
            }
        }      
    }

    public void findContact(int searchParameter, String queryValue) {
        String compareValue;
        for (Contact storedContact : this.addressBook) {
            switch(searchParameter) {
                case 1:
                    compareValue = storedContact.getFirstName();
                    break;
                case 2:
                    compareValue = storedContact.getLastName();
                    break;
                case 3:
                    compareValue = storedContact.getPhoneNumber();
                    break;
                case 4:
                    compareValue = storedContact.getEmailAddress();
                    break;
            }
            if(compareValue == queryValue) {
                System.out.println("The following contact matches your search parameters:");
                System.out.println(storedContact.toString());
            }
        }
    }

    public void seeAllContacts() {
        for (Contact storedContact : this.addressBook) {
            System.out.println(storedContact.toString());
        }
    }

    public void removeAllContacts() {
        this.addressBook.clear();
    }
}
