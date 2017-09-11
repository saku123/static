package org.learning.statics.dao.impl;

import org.learning.statics.dao.ContentsDao;
import org.learning.statics.model.Contents;
import org.learning.statics.model.Mapper.ContensRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * Created by jieli5 on 8/21/2017.
 */
@Repository
public class ContentsDaoImpl implements ContentsDao{

    @Autowired
    @Qualifier("tutorialsJdbcTemplate")
    private JdbcTemplate tutorialsJdbcTemplate;

    @Autowired
    @Qualifier("cmsJdbcTemplate")
    private JdbcTemplate cmsJdbcTemplate;

    @Override
    public List<Contents> queryContentsByTutorialName(String tutorialName) {
        String sql = "select * from "+tutorialName+" where pageurl like '%/"+tutorialName+"/%' and title <> '' order by id";
        return tutorialsJdbcTemplate.query(sql,new ContensRowMapper());
    }

    @Override
    public int insertContentAndAttribute2CMS(List<Contents> contentList) {
        int records = 0;
        final String sql = "insert into cms_content (site_id,title,user_id,check_user_id,category_id,model_id,parent_id,copied,childs,clicks,create_date,publish_date,sort,status,disabled,comments)" +
                "values(1,?,1,1,4,'chapter',17,0,0,0,?,?,?,1,0,0)";
        final String sqlAttribute = "insert into cms_content_attribute(content_id,text,word_count) values (?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        System.out.println("开始insert");
        for(Contents item : contentList){
            final int sort = records;
            final String title = item.getTitle();
            cmsJdbcTemplate.update(new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection conn)
                        throws SQLException {
                    PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1,title);
                    ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                    ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                    ps.setInt(4,sort);
                    return ps;
                }
            }, keyHolder);
            int key = keyHolder.getKey().intValue();
            cmsJdbcTemplate.update(sqlAttribute,key,item.getContent(),item.getContent().length());
            records++;
        }
        System.out.println("结束insert");
        return records;
    }
}
