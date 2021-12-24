import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class mathClass = Class.forName("java.lang.Math");
        System.out.println("There it is!");
        Constructor[] declaredConstructors = mathClass.getDeclaredConstructors();
        Constructor[] constructors = mathClass.getConstructors();
        Field[] declaredFields = mathClass.getDeclaredFields();
        Field[] fields = mathClass.getFields();
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        Method[] methods = mathClass.getMethods();
        for(Constructor dc : declaredConstructors) {
            System.out.println("Declared Constructor " + dc.getName());
        }
        for (Constructor c : constructors) {
            System.out.println("Constructor " + c.getName());
        }
        for (Field df : declaredFields) {
            System.out.println("Declared Field " + df.getName());
        }
        for (Field f : fields) {
            System.out.println("Field " + f.getName());
        }
        for (Method dm : declaredMethods) {
            System.out.println("Declared Method " + dm.getName());
        }
        for (Method m : methods) {
            System.out.println("Method " + m.getName());
        }
    }
}
