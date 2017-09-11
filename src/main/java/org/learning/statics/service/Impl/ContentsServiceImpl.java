package org.learning.statics.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.learning.statics.dao.ContentsDao;
import org.learning.statics.model.Contents;
import org.learning.statics.service.ContentsService;
import org.learning.statics.utils.StaticPageUtil;
import org.learning.statics.utils.TranslateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jieli5 on 8/21/2017.
 */
@Service
public class ContentsServiceImpl implements ContentsService{
    @Autowired
    private ContentsDao contensDao;

    @Autowired
    private TranslateUtil translateUtil;

    @Autowired
    private StaticPageUtil staticPageUtil;

    @Override
    public List<String> generateStaticPages() {
        List<Contents> list = null;//contensDao.findAll();
        List<String> pageNameList = null;
        if (list != null){
            pageNameList = new ArrayList<String>();
            for (Contents item : list){
                String content = item.getContent();
                String title = item.getTitle();
                Document doc = Jsoup.parse(content);
                Elements els = doc.body().getAllElements();
                Elements pngs = doc.select("img[src~=(?i)\\.(png|jpe?g)]");
                for (Element e : els) {
                    if(e.nodeName() == "pre" || e.nodeName() == "b" ||
                            e.nodeName() == "td" || e.nodeName() == "th" || e.nodeName() == "h2"){
                        continue;
                    }
                    List<TextNode> tnList = e.textNodes();
				for (TextNode tn : tnList){
					String orig = tn.getWholeText();
					if(StringUtils.isNotBlank(orig)){
						String translateOrig = translateUtil.translte(orig);
						tn.text(translateOrig);
					}
				}
                }
                //staticPageUtil.downLoadImages("https://www.tutorialspoint.com",pngs);
                staticPageUtil.staticPage(title,doc.toString(),list);
                pageNameList.add(title);
            }
        }
        return pageNameList;
    }

    @Override
    public List<Contents> queryContents(String tutorialName) {
        return contensDao.queryContentsByTutorialName(tutorialName);
    }

    @Override
    public Integer insertContents2CMS(String tutorialName) {
        List<Contents> list = this.queryContents(tutorialName);
        System.out.println("开始翻译");
        for (Contents item : list){
            String content = item.getContent();
            content = content.replaceAll("(?i)tutorials point","kzz");
            String title = item.getTitle();
            Document doc = Jsoup.parse(content);
            Elements els = doc.body().getAllElements();
            //Elements pngs = doc.select("img[src~=(?i)\\.(png|jpe?g)]");
            for (Element e : els) {
                if(e.nodeName() == "pre" || e.nodeName() == "b" ||
                        e.nodeName() == "td" || e.nodeName() == "th" || e.nodeName() == "h2"){
                    continue;
                }
                if(e.nodeName() == "img"){
                    staticPageUtil.downLoadImages("https://www.tutorialspoint.com",e,tutorialName);
                }
                List<TextNode> tnList = e.textNodes();
                for (TextNode tn : tnList){
                    String orig = tn.getWholeText();
                    if(StringUtils.isNotBlank(orig)){
                        String translateOrig = translateUtil.translte(orig);
                        tn.text(translateOrig);
                    }
                }
            }
            item.setContent(doc.select("body>*").toString());
        }
        System.out.println("翻译结束");
        return contensDao.insertContentAndAttribute2CMS(list);
    }
}
