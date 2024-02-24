package System.util.nativGate;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class CarFile extends ZipFile {
    private final String name;
    private final String name_all;
    public CarFile(String name,String name_all) throws IOException {
        super(name);
        this.name = name;
        this.name_all = name_all;
    }
    public ArrayList<String> getProperties() throws IOException {
        ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(name_all)), Charset.forName("GBK"));
        Properties properties = new Properties();
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        ZipEntry ze = null;
        while ((ze = zipIn.getNextEntry()) != null) {
            if (ze.getName().equals("packageDescription.properties")) {
                //准备BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(zipIn, Charset.forName("GBK")));
                while ((line = br.readLine()) != null) {
                    arrayList.add(line);
                }
                br.close();//关闭BufferedReader，避免占用资源
                break;//跳出循环
            }
        }
        return arrayList;
    }

    /**
     * 按照名称搜索符合条件的ZipEntry，并返回
     * @param name 名称
     * @throws IOException 当发生I/O异常
     */
    public ZipEntry searchEntry(String name) throws IOException {
        ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(name_all)), Charset.forName("GBK"));
        ZipEntry ze = null;
        while ((ze = zipIn.getNextEntry()) != null) {
             if (ze.getName().equals(name)){
                 break;
             }
        }
        return ze;
    }
}
