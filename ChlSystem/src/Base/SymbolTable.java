package Base;

import java.util.HashMap;

// 自定义函数类，用于存储函数信息
class Function {
    private String name; // 函数名称
    private String returnType; // 返回值类型
    private String[] parametersname; // 参数列表

    // 构造函数，初始化函数信息
    public Function(String name, String returnType, String[] parameters) {
        this.name = name;
        this.returnType = returnType;
        this.parametersname = parameters;
    }

    /**
     * 目标：获取函数名
     */
    public String getName() {
        return name;
    }

    /**
     * 目标：获取返回值
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     *
     */
    public String[] getParameters() {
        return parametersname;
    }
}

public class SymbolTable {
    private HashMap<String, Function> symbolMap; // 使用 HashMap 存储函数名称和对应的 Function 对象

    // 构造函数，初始化符号表
    public SymbolTable() {
        symbolMap = new HashMap<>();
    }

    // 添加函数到符号表
    public void putFunction(String name, Function function) {
        symbolMap.put(name, function);
    }

    // 获取符号表中指定函数的信息
    public Function getFunction(String name) {
        return symbolMap.get(name);
    }

    // 判断符号表中是否包含指定函数
    public boolean containsFunction(String name) {
        return symbolMap.containsKey(name);
    }

    // 从符号表中移除指定函数
    public void removeFunction(String name) {
        symbolMap.remove(name);
    }

    // 测试代码
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();

        // 创建 add 函数对象并添加到符号表
        Function addFunction = new Function("add", "int", new String[]{"int", "int"});
        symbolTable.putFunction("add", addFunction);

        // 创建 sub 函数对象并添加到符号表
        Function subFunction = new Function("sub", "int", new String[]{"int", "int"});
        symbolTable.putFunction("sub", subFunction);

        // 获取并打印 add 函数的信息
        Function getResult = symbolTable.getFunction("add");
        System.out.println("Function Name: " + getResult.getName());
        System.out.println("Return Type: " + getResult.getReturnType());
        System.out.println("Parameters: " + String.join(", ", getResult.getParameters()));
    }
}