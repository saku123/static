package org.learning.statics.dao.impl;

import org.learning.statics.dao.ContentsDao;
import org.learning.statics.model.Contents;
import org.learning.statics.model.Mapper.ContensRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jieli5 on 8/21/2017.
 */
@Repository
public class ContentsDaoImpl implements ContentsDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Contents> queryContentsByTutorialName(String tutorialName) {
        String sql = "select * from "+tutorialName+" where pageurl like '%/"+tutorialName+"/%' and title <> '' order by id";
        return jdbcTemplate.query(sql,new ContensRowMapper());
    }
}
