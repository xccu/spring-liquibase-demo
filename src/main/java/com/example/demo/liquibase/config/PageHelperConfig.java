package com.example.demo.liquibase.config;

import com.github.pagehelper.PageInterceptor;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/** 自定注入分页插件 */
@Configuration
//@AutoConfigureAfter(MybatisPlusConfig.class) //设置配置的顺序
public class PageHelperConfig {

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @PostConstruct
    PageInterceptor addPageInterceptor() {
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("params", "count=countSql");
        interceptor.setProperties(properties);
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
        }
        return interceptor;
    }
}
