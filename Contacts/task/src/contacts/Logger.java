package contacts;

import java.io.*;
import java.time.LocalDateTime;

public class Logger implements Serializable {
    private PhoneBook phonebook;

    public Logger(PhoneBook phonebook) {
        this.phonebook = phonebook;
    }

    public void log(Entity entity, Actions action) {
        try (OutputStream stream = new FileOutputStream("C:\\Users\\Moham\\Contacts1\\Contacts\\task\\src\\contacts\\LogFiles.txt", true)) {
            stream.write((LocalDateTime.now() + "\n").getBytes());
            stream.write((action + "\n").getBytes());
            stream.write((entity.toString() + "\n\n").getBytes());
            ;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void log(Actions action) {
        try (OutputStream stream = new FileOutputStream("C:\\Users\\Moham\\Contacts1\\Contacts\\task\\src\\contacts\\LogFiles.txt", true)) {
            stream.write((LocalDateTime.now() + "\n").getBytes());
            stream.write((action + "\n\n").getBytes());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
