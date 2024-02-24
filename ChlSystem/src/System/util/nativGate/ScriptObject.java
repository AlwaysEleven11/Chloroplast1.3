package System.util.nativGate;

import java.io.IOException;

public class ScriptObject{
       private String objectName;
       public ScriptObject(String objectName){
           this.objectName = objectName;
       }
       public void execute() throws IOException {
           ProcessBuilder processBuilder = new ProcessBuilder("start " + objectName);
           processBuilder.start();
       }
}

