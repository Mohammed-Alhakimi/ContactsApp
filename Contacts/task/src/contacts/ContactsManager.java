package contacts;

import java.util.List;

public interface ContactsManager {
    void add();
    void list();
    void count();
    List<Entity> search();
}
