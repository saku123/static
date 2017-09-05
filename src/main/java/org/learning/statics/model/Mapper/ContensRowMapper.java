package org.learning.statics.model.Mapper;

import org.learning.statics.model.Contents;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jieli5 on 9/5/2017.
 */
public class ContensRowMapper implements RowMapper<Contents>{

    @Override
    public Contents mapRow(ResultSet resultSet, int i) throws SQLException {
        Contents contents = new Contents();
        contents.setId(resultSet.getInt("id"));
        contents.setContent(resultSet.getString("content"));
        contents.setTitle(resultSet.getString("title"));
        contents.setPageUrl(resultSet.getString("pageurl"));
        return contents;
    }
}
