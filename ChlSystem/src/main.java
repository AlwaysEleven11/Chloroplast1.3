import Base.Grammar;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Chloroplast BaseShell v1.3\n输入 \"help\" 获取帮助。");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equals("help")){
            printHelp();
        }
        if (scanner.nextLine().equals("chl")){
            String[] argsnew = Arrays.toString(args).split(" ");
            if(args != null){
                System.out.println("指定附加选项：");
                for (String s: args) {
                    if(s.equals("-dcv")) {
                        System.out.println("[调试功能]检查变量");
                        Grammar.debugcheckvars = true;
                    }
                    if(s.equals("-log")){
                        System.out.println("[调试功能]日志输出");
                    }
                }
            }
        }
    }
    public static void printHelp(){
        System.out.println("Chloroplast BaseShell 帮助文档");
        System.out.println("help - 显示本界面");
        System.out.println("chl - 运行Chloroplast源文件，具体用法：");
        System.out.println("-dcv 指定调试功能变量检查");
        System.out.println("-log 指定调试功能日志输出");
        System.out.println("-f 运行文件路径");
        System.out.println("-o 启用联合编译，此后的参数不被算作参数，一概视为文件路径，详见BaseShellHelp.md");
    }
}
