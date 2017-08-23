package org.learning.statics.config;

import org.learning.statics.utils.StaticPageUtil;
import org.learning.statics.utils.TranslateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jieli5 on 8/21/2017.
 */
@Configuration
public class UtilsConfig {
    @Value("${translate.url}")
    private String translateUrl;

    @Value("${generate.page.path}")
    private String path;

    @Value("${generate.image.path}")
    private String imagePath;

    @Bean
    public TranslateUtil tranlateUtil() {
        return new TranslateUtil(translateUrl);
    }

    @Bean
    public StaticPageUtil staticPageUtil() {
        return new StaticPageUtil(path,imagePath);
    }

}
