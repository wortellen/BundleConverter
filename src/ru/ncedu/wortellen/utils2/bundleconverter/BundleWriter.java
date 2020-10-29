package ru.ncedu.wortellen.utils2.bundleconverter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;


public class BundleWriter {
    FileWriter writer;

    BundleWriter(String fileName) throws IOException {
        writer = new FileWriter(fileName.substring(0, fileName.indexOf(".java")) + ".properties");
    }

    public void writeBundle(Matcher matcher) throws IOException {
        writer.write(matcher.group(3) + "=" + matcher.group(5) + "\n");
    }

    public void writeBundleWithComment(Matcher matcher) throws IOException {
        writer.write(matcher.group(3) + "=" + matcher.group(5) + "#" + matcher.group(7).substring(2) + "\n");
    }

    public void close() throws IOException {
        writer.close();
    }
}
