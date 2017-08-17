package org.learning.statics;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
	
	public static void main(String args[]) throws SQLException{
		String sql = "select id,title,content,pageurl from mongodb where id = 5";
		DBHelper dbHelper = new DBHelper(sql);
	 	ResultSet rs =  dbHelper.pst.executeQuery();
		while(rs.next()){
			String content = rs.getString("content");
			String title = rs.getString("title");
			Document doc = Jsoup.parse(content);
			Elements els = doc.body().getAllElements();
			for (Element e : els) {
				if(e.nodeName() == "pre"){
					continue;
				}
				List<TextNode> tnList = e.textNodes();
				/*
				for (TextNode tn : tnList){
					String orig = tn.getWholeText();
					if(StringUtils.isNotBlank(orig)){
						String translateOrig = PostHelper.transltePost(orig);
						tn.text(translateOrig);
					}
				}*/
			}
			//System.out.println(title);
			//StaticPageHelper.staticPage(title,doc.outerHtml());
		}
	}
	
	

}


