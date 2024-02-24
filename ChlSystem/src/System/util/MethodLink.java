package System.util;

import java.lang.reflect.Method;

public class MethodLink {
    public static Method loadLocalMethod(String name,Class<?> clazz,Class<?>... parameterTypes) throws NoSuchMethodException {
            Method function = clazz.getDeclaredMethod(name,parameterTypes);
            ((Method) function).setAccessible(true);
            return function;
    }
}
