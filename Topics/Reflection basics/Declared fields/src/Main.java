import java.lang.reflect.Field;

/**
 Get number of fields class declares (the ones inherited should be excluded).
 */
class FieldGetter {

    public int getNumberOfFieldsClassDeclares(Class<?> clazz) {
        int count = 0;
        for (Field c : clazz.getDeclaredFields()) {
            count++;
        }

        return count;
    }

}