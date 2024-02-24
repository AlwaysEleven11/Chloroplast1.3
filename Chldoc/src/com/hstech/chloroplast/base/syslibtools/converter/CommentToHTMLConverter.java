package com.hstech.chloroplast.base.syslibtools.converter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommentToHTMLConverter {
    static Boolean shouldWrite = false;
    private enum GivenHTMLTokens{
        html,
        head,body,
        div;
    }
    public static void converter(File file) {
        BufferedWriter writer;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
            writer = new BufferedWriter(new FileWriter(file.getAbsolutePath().replace(".chl", "") + "-Doc.html", StandardCharsets.UTF_8));
            File file2 = new File(file.getPath().replace(file.getName(), "") + "/resource/doc.css");
            writer.write("<html>");
            writer.write("<head>");
            if (!Files.exists(Path.of(file.getPath().replace(file.getName(), ""))) && Files.isDirectory(Path.of(file.getPath().replace(file.getName(), "")))) {
                Files.createDirectory(Path.of(file.getPath().replace(file.getName(), "")));
                Files.copy(Path.of("D:/Chloroplast/Resources/doc.css"), Path.of(file.getPath().replace(file.getName(), "") + "\\resource\\doc.css"));
                System.out.println("Created file " + file.getPath().replace(file.getName(), "") + "\\resource\\doc.css");
            }
            if (!file2.exists()) {
                throw new FileNotFoundException("No such doc.css file found,please delete this folder,and run once more.");
            }
            writer.write("<link rel=\"stylesheet\" href=\"resource/doc.css\">");
            writer.write("<meta charset=\"UTF-8\">");
            writer.write("<title>Chloroplast Document</title>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<div class=\"top-bar\">");
            writer.write("<h1 style=\"color:white\">Chloroplast Document</h1>");
            writer.write("</body>");
            String line;
            while ((line = reader.readLine()) != null) {
            }
            writer.flush();
            reader.close();
            writer.close();

            System.out.println("Complete convert in" + Math.round(System.currentTimeMillis()) + " Second");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}