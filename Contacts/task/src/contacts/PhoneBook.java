package contacts;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook implements ContactsManager, Serializable {

    private ArrayList<Entity> listContacts;
    private Logger logger = new Logger(this);
    private String currentProcess;

    public PhoneBook(ArrayList<Entity> listContacts) {
        this.listContacts = listContacts;
    }

    public void add() {
        Scanner s = new Scanner(System.in);
        EntityFactory factory = new EntityFactory();
        System.out.print("Enter the type (person, organization): ");
        String type = s.nextLine();
        Entity e = factory.makeEntity(type);
        if (e != null) {
            Entity newContact = e.createEntity();
            logger.log(newContact, Actions.CONTACT_ADDED);
            listContacts.add(newContact);
        } else {
            System.out.println("Wrong entry!\n");
        }
    }

    public void count() {
        System.out.println("The Phone Book has " + listContacts.size() + " records.\n");
        logger.log(Actions.PHONEBOOK_COUNT_VIEWED);
    }

    public void list() {
        int counter = 0;
        if (listContacts.size() == 0) {
            System.out.println("There are no records to show\n");
        } else {
            for (Entity e : listContacts
            ) {
                counter++;
                System.out.println(counter + ". " + e.displayFullName());
            }
            System.out.println();
            showListActions();
        }
    }

    public List<Entity> search() {
        List<Entity> foundEntities = new ArrayList<>();
        int countForFoundEntities = 0;
        Scanner S = new Scanner(System.in);
        System.out.print("Enter Search query: ");
        Pattern pattern = Pattern.compile(S.nextLine(), Pattern.CASE_INSENSITIVE);
        logger.log(Actions.SEARCH_QUERY_CONDUCTED);
        for (Entity e : listContacts
        ) {
            Matcher matcher = pattern.matcher(e.displayFullName());
            Matcher matcher1 = pattern.matcher(e.getNumber());
            while (matcher.find() || matcher1.find()) {
                foundEntities.add(e);
                countForFoundEntities++;
            }
        }
        if (!foundEntities.isEmpty()) {
            System.out.println("Found " + countForFoundEntities + " results:");
            for (int i = 0; i < foundEntities.size(); i++) {
                System.out.println(i + 1 + ". " + foundEntities.get(i).displayFullName());
            }
        }
        setCurrentProcess("[search] ");
        return foundEntities;
    }

    public void setCurrentProcess(String currentProcess) {
        this.currentProcess = currentProcess;
    }

    public void ShowActions() {
        boolean notExit = true;
        setCurrentProcess("[menu] ");
        while (notExit) {
            Scanner s = new Scanner(System.in);
            System.out.print(currentProcess + "Enter action (add, list, search, count, exit): ");
            String choice = s.nextLine();
            switch (choice) {
                case "add":
                    this.add();
                    break;
                case "list":
                    this.list();
                    break;
                case "count":
                    this.count();
                    break;
                case "search":
                    this.searchActions(search());
                    break;
                case "exit":
                    notExit = false;
                    s.close();
                    break;
                default:
                    System.out.println("Wrong entry! please try again\n");
                    break;
            }
        }
    }

    private void searchActions(List<Entity> e) {
        Scanner s = new Scanner(System.in);
        boolean stillSearching = true;
        while (stillSearching) {
            System.out.print("\n" + currentProcess + "Enter action ([number], back, again): ");
            String choiceSearchSubMenu = s.nextLine();
            try {
                int choice = Integer.parseInt(choiceSearchSubMenu);
                System.out.println(e.get(choice - 1).toString());
                this.setCurrentProcess("[record] ");
                showRecordActions(e.get(choice - 1));
            } catch (Exception e2) {
                switch (choiceSearchSubMenu) {
                    case "again":
                        this.searchActions(search());
                        break;
                    case "back":
                        this.currentProcess = "[menu] ";
                        System.out.println();
                        break;
                    default:
                        System.out.println("Wrong Entry\n");
                        break;
                }
            }
            stillSearching = false;
        }
    }

    private void showListActions() {
        Scanner s = new Scanner(System.in);
        currentProcess = "[list] ";
        System.out.print(currentProcess + "Enter action([number], back): ");
        String choiceList = s.nextLine();
        try {
            int choice = Integer.parseInt(choiceList);
            logger.log(listContacts.get(choice - 1), Actions.INFO_FOR_CONTACT_REQUESTED);
            System.out.println(listContacts.get(choice - 1).toString());
            this.setCurrentProcess("[record] ");
            showRecordActions(listContacts.get(choice - 1));
        } catch (Exception e) {
            if (choiceList.equalsIgnoreCase("back")) {
                this.currentProcess = "[menu] ";
                System.out.println();
            } else {
                System.out.println("Wrong Entry!\n");
            }
        }
    }

    private void showRecordActions(Entity e) {
        Scanner s = new Scanner(System.in);
        boolean viewingRecord = true;
        while (viewingRecord) {
            System.out.print(currentProcess + "Enter action (edit, delete, menu): ");
            switch (s.nextLine()) {
                case "edit":
                    Entity modEntity = e.modifyEntity();
                    logger.log(modEntity, Actions.CONTACT_EDITED);
                    System.out.println("Saved");
                    System.out.println(e);
                    break;
                case "delete":
                    logger.log(e, Actions.CONTACT_DELETED);
                    listContacts.remove(e);
                    break;
                case "menu":
                    viewingRecord = false;
                    System.out.println();
                    break;
                default:
                    System.out.println("Wrong entry!\n");
            }
        }
        this.setCurrentProcess("[menu] ");
    }

}
