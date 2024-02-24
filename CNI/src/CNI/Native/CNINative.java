package CNI.Native;

import java.lang.reflect.Method;

public class CNINative {
    private static String NATIVE_LIB;
    public CNINative(String NATIVE_LIB){
        CNINative.NATIVE_LIB = NATIVE_LIB;
    }
    static {
        System.loadLibrary(NATIVE_LIB);
    }
    public static void callNativeFunction(String name) {
        try {
            // 获取本地函数的Method对象
            Method nativeFunc = CNINative.class.getDeclaredMethod(name);
            // 设置可访问性，如果函数是私有的
            ((Method) nativeFunc).setAccessible(true);
            // 调用本地函数
            nativeFunc.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
