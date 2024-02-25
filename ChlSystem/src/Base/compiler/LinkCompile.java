package Base.compiler;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class LinkCompile {
    java.util.ArrayList<String> collectedPaths;
     public ArrayList<String> collect(String[] paths){
         for (String s:paths) {
             collectedPaths.add(s);
         }
         return collectedPaths;
     }
     public void compile(){

     }
}
