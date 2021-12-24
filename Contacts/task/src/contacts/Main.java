package contacts;


import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Entity> entities = new ArrayList<>();
    static PhoneBook book = new PhoneBook(entities);
    static Logger logger = new Logger(book);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            book = (PhoneBook) SerializatonUtils.deserialize("C:\\Users\\Moham\\Contacts1\\Contacts\\task\\src\\contacts\\SerializationFile.txt");
        } catch (EOFException e) {
            System.out.println("Deserialization failed");
        }
        System.out.println("open phonebook.db\n");
        logger.log(Actions.APPLICATION_STARTED);
        book.ShowActions();
        logger.log(Actions.APPLICATION_EXITED);
        SerializatonUtils.serialize(book, "C:\\Users\\Moham\\Contacts1\\Contacts\\task\\src\\contacts\\SerializationFile.txt");
    }
}