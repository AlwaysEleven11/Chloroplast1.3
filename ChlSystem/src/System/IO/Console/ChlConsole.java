package System.IO.Console;

import Base.MethodConvertList;

import java.io.PrintStream;

public class ChlConsole implements MethodConvertList {

     @Override
     public void chlout(String s) {
          System.out.print(s);
     }

     @Override
     public void chloutln(String s) {
          System.out.println(s);
     }
}