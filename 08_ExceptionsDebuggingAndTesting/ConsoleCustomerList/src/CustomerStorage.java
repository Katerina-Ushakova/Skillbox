import java.util.HashMap;

public class CustomerStorage
{
    private final int PHONE_NUMBER = 12;
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format! Correct format: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        String name = components[0] + " " + components[1];
        if (!(components[2].matches("^([A-Za-z0-9_-]+\\.)*[A-Za-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*$"))) {
            throw new IllegalArgumentException("Wrong email's format! Correct format: \n" +
                    "vasily.petrov@gmail.com");
        }
       if(!((components[3].matches("[+0-9]+"))
                && components[3].length() == PHONE_NUMBER)) {
            throw new IllegalArgumentException("Wrong phone number's format! Correct format: \n" +
                    "+79215637722");
        }
        storage.put(name, new Customer(name, components[3], components[2]));
        System.out.println("Customer was added");
    }

    public void listCustomers()
    {   if (storage.size() == 0) {
        System.out.println("List is empty!");
    }
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        String [] arrayName = name.split("\\s+");
        if (arrayName.length != 2 || name.length() == 0) {
            try {
                throw new CustomerException("Wrong format! Correct format: \n" +
                        "remove Василий Петров");
            } catch (CustomerException e) {
                e.printStackTrace();
            }
        }
        if(storage.containsKey(name)) {
            storage.remove(name);
            System.out.println("Customer removed!");
        } else
            System.out.println("Customer isn't found");
    }

    public int getCount()
    {   if (storage.size() == 0) {
        System.out.println("List is empty!");
    }
        return storage.size();
    }

    class CustomerException extends IllegalArgumentException {

        public CustomerException (String message) {
            super(message);
        }

    }
}