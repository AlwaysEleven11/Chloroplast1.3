package System;

import System.util.MethodLink;
import System.util.nativGate.CarFile;
import System.util.nativGate.Library;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ChlSystem {
    ArrayList<Method> methodIndexList = new ArrayList<>();
    public void instantSystem() throws NoSuchMethodException {
        methodIndexList.add(MethodLink.loadLocalMethod("chlout", ChlSystem.class, String.class));
        methodIndexList.add(MethodLink.loadLocalMethod("searchEntry", CarFile.class, String.class));
        methodIndexList.add(MethodLink.loadLocalMethod("getProperties", CarFile.class, null));
    }
    public static void chlout(String x){
        System.out.println(x);
    }
    public static Library createLibraryLink(String pathname,String name) throws IOException {
        return new Library(pathname, name);
    }
}
