package org.learning.statics.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by jieli5 on 9/7/2017.
 */
@Configuration
public class JdbcTemplateConfig {
    @Bean(name = "tutorialsJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("tutorialsDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "cmsJdbcTemplate")
    public JdbcTemplate cmsJdbcTemplate(
            @Qualifier("cmsDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
