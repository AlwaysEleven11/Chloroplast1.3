package Base;

import java.util.ArrayList;
import java.util.HashMap;

public class Grammar {
    public static boolean debugcheckvars = false;
    static String coreKeyWord;
    static HashMap<String, String> variableMap = new HashMap<>();

    /**
     * 目标：对输入的数组表进行语法检查，确保无误
     */
    public static void gram(ArrayList<String> lexList){
        for (int i = 0; i < lexList.size(); i++) {
            //定义关键字
            if (lexList.get(i).equals("var")) {
                if (lexList.get(i + 1) instanceof String){
                    if (lexList.get(i + 2).equals("=")) {
                        if (lexList.get(i + 3) != null) {
                            if (ExpressionCalculator.isEquation(lexList.get(i + 3))) {//判断等式
                                // 解析等号右侧的表达式，并将计算结果存储到变量中
                                String variableName = lexList.get(i + 1);
                                String result = String.valueOf(ExpressionCalculator.evaluateExpression(lexList.get(i + 3)));
                                // 存储变量名和对应的值
                                variableMap.put(variableName, result);
                            } else {
                                // 获取等号右侧的值
                                String variableName = lexList.get(i + 1);
                                String result = lexList.get(i + 3);
                                // 存储变量名和对应的值
                                variableMap.put(variableName, result);
                            }
                        } else {
                            throw new RuntimeException("(0x03)The variable maybe need a value or expression.");
                        }
                    }
                }else{
                    throw new RuntimeException("(0x01)The variable need a name!");
                }
            }
            if(lexList.get(i).equals("function")){
               
            }
        }
    }
    public static void debugCheckVariables(){
        for (String key : variableMap.keySet()) {
            String value = variableMap.get(key);
            System.out.println("变量名：" + key + "，值：" + value);
        }
    }
    public static void main(String[] args) {
       ArrayList<String> list = Lexer.lex("var xxx = 114514");
       gram(list);
       if (debugcheckvars){
           debugCheckVariables();
       }
    }
}
