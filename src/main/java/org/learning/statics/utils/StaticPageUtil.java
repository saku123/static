package org.learning.statics.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.learning.statics.model.Contents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jieli5 on 8/21/2017.
 */
public class StaticPageUtil {

    @Autowired
    private Configuration config;

    private final String FILE_PATH;
    private final String IMAGES_PATH;

    public StaticPageUtil(String path,String imagePath){
        this.FILE_PATH = path;
        this.IMAGES_PATH = imagePath;
    }

    public void staticPage(String title , String htmlStr, List<Contents> list){
        File file = null;
        FileOutputStream os = null;
        OutputStreamWriter osw = null;
        Writer w = null;
        Map<String,Object> map = null;
        try {
            map = new HashMap<String,Object>();
            map.put("contentList",list);
            map.put("title",title);
            map.put("htmlStr",htmlStr);
            config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template temple=config.getTemplate("pageTemplate.ftl");
            String outPutStr = FreeMarkerTemplateUtils.processTemplateIntoString(temple,map);
            file = new File(FILE_PATH+"/"+title+".html");
            os = new FileOutputStream(file);
            osw = new OutputStreamWriter(os);
            w = new BufferedWriter(osw);
            w.write(outPutStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
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

    public void downLoadImages(String prefix,Elements pngs){
        URL url = null;
        URLConnection uri = null;
        InputStream is = null;
        OutputStream os = null;
        try{
            for(Element e : pngs){
                String src=prefix+e.attr("src");//获取img中的src路径
                String imageName = src.substring(src.lastIndexOf("/") + 1,src.length());
                url = new URL(src);
                uri=url.openConnection();
                is=uri.getInputStream();
                os = new FileOutputStream(new File(IMAGES_PATH, imageName));
                byte[] buf = new byte[1024];
                int l=0;
                while((l=is.read(buf))!=-1){
                    os.write(buf, 0, l);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (is != null){
                    is.close();
                }
                if (os != null){
                    os.flush();
                    os.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
