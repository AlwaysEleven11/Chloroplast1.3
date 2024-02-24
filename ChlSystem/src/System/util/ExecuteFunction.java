package System.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExecuteFunction {
    String FunctionName;
    String FilePath;
    ArrayList<String> FuncContent = new ArrayList<>();
    public ExecuteFunction(String FunctionName,String FilePath){
        this.FunctionName = FunctionName;
        this.FilePath = FilePath;
    }
    public void execute(){

    }
    public void find() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FilePath));
        String line;
         while((line = br.readLine()) != null){
             if(line.contains(FunctionName)){
                 break;
             }
         }
        if (line != null) {
            pushIn(String.format(line, FunctionName));
        }
    }
    public void pushIn(String Content){
        FuncContent.add(Content);
    }
}
