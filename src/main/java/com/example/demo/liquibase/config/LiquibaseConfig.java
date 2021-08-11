package com.example.demo.liquibase.config;

import liquibase.change.DatabaseChange;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@ConditionalOnClass({SpringLiquibase.class, DatabaseChange.class})
@AutoConfigureAfter({DataSource.class})
@ConditionalOnProperty(prefix = "spring.liquibase", name = "enabled", matchIfMissing = true)
@Configuration
public class LiquibaseConfig {

    @Bean("liquibase")
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.xml");
        //liquibase.setContexts("sonar,debug,local,dev,test");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}
