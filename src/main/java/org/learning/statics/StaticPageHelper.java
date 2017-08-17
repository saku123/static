package org.learning.statics;

import java.io.*;

/**
 * Created by jieli5 on 8/15/2017.
 */
public class StaticPageHelper {
    private static final String FILE_PATH = "C:/Users/jieli5/Desktop/static_pages";

    public static void staticPage(String title , String htmlStr){
        File file = null;
        FileOutputStream os = null;
        OutputStreamWriter osw = null;
        Writer w = null;
        try {
            file = new File(FILE_PATH+"/"+title+".html");
            os = new FileOutputStream(file);
            osw = new OutputStreamWriter(os);
            w = new BufferedWriter(osw);
            w.write(htmlStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(w != null){
                    w.flush();
                    w.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
