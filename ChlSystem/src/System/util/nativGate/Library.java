package System.util.nativGate;

import java.io.IOException;
import java.util.zip.ZipEntry;

public class Library extends CarFile{
    private final String path;
    private final String name;
    public Library(String path,String name) throws IOException {
        super(name,path);
        this.path = path;
        this.name = name;
    }
}
