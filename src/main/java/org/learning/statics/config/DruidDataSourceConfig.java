package org.learning.statics.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by jieli5 on 8/21/2017.
 */
@Configuration
public class DruidDataSourceConfig {

    @Primary
    @Bean(name = "tutorialsDataSource")
    @Qualifier("tutorialsDataSource")
    @ConfigurationProperties(prefix="spring.datasource.tutorials")
    public DataSource tutorialsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "cmsDataSource")
    @Qualifier("cmsDataSource")
    @ConfigurationProperties(prefix="spring.datasource.cms")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}
