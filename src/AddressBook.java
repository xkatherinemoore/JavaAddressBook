import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
    private List<Contact> addressBook;
    
    public AddressBook() {
        addressBook = new ArrayList<Contact>();
    }
    
    public int getSize() {
    	return addressBook.size();
    }

    public void addContact(Contact contact) {
        this.addressBook.add(contact);
        System.out.println("Adding contact...");
        contact.toString();
        System.out.println("Contact successfully added!");
        
    }

    public void removeContact(String emailAddress) {
    	boolean foundEntry = false;
        for(Contact storedContact : this.addressBook) {
            if(storedContact.getEmailAddress().equals(emailAddress)) {
                System.out.println("The following contact was successfully removed:");
                storedContact.toString();
                this.addressBook.remove(storedContact);
                foundEntry = true;
                break;
            }    
        }
        
        if (!foundEntry) {	
            System.out.println("The entered email address could not be found in your contacts");
        }
    }

    public void findContact(int searchParameter, String queryValue) {
    	Pattern pattern = Pattern.compile(("[" + queryValue + "]+"), Pattern.CASE_INSENSITIVE);
    	String compareValue;
    	int matches = 0;
        
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
                default:
                	compareValue = "";
            }
            
            Matcher matcher = pattern.matcher(compareValue);
            if(matcher.find()) {
                System.out.println("The following contact matches your search parameters:");
                storedContact.toString();
                matches++;
            }
        }
        if (matches == 0) {
        	System.out.println("No matches were found in the address book");
        }
    }

    public void seeAllContacts() {
        for (Contact storedContact : this.addressBook) {
            storedContact.toString();
        }
    }

    public void removeAllContacts() {
        this.addressBook.clear();
    }
}
