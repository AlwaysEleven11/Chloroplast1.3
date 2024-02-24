package Base;

import java.util.ArrayList;
import java.util.Arrays;

public class Lexer {
    public static ArrayList<String> lex(String code){
        return new ArrayList<String>(Arrays.asList(code.split(" ")));
    }
}
