package contacts;

public class EntityFactory {
    public Entity makeEntity(String type) {
        if (type.equalsIgnoreCase("person")) {
            return new Person();
        } else if (type.equalsIgnoreCase("organization")) {
            return new Organization();
        }
        return null;
    }
}
