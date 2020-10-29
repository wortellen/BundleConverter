package ru.ncedu.wortellen.utils2.bundleconverter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BundleConverter {
    public static void main(String[] args) throws FileNotFoundException {
        Pattern patternLRB = Pattern.compile("(.*?)(\\{\")(.*?)(\",\\s\")(.*?)(\"\\},?)(.*?)");
        for (String str : args) {
            try {
                File file = new File(str);
                FileInputStream fis = new FileInputStream(str);
                BundleWriter bw = new BundleWriter(str);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
                String line = reader.readLine();
                while (line != null) {
                    Matcher matcher = patternLRB.matcher(line);
                    if (matcher.matches()) {
                        if (matcher.group(7).equals("")) {
                            bw.writeBundle(matcher);
                        } else {
                            bw.writeBundleWithComment(matcher);
                        }
                    }

                    line = reader.readLine();
                }
                fis.close();
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
