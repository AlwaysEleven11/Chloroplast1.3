import com.hstech.chloroplast.base.syslibtools.converter.CommentToHTMLConverter;

import java.io.*;
import java.util.Objects;

public class main {
    static String DocArg;
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], "-FileDir")) {
                DocArg = args[i+1];
                ++i;
            }
        }
        CommentToHTMLConverter.converter(new File(DocArg));
    }
}
