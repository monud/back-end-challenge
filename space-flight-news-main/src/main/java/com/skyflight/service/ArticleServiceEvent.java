package com.skyflight.service;

import org.springframework.context.ApplicationEvent;
import org.apache.commons.io.IOUtils;

/**
 * This is an optional class used in publishing application events.
 * This can be used to inject events into the Spring Boot audit management endpoint.
 */
public class ArticleServiceEvent extends ApplicationEvent {

    public ArticleServiceEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "My ArticleService Event";
    }

    @Scheduled(cron = "0 0 9 * * ?")
    public void executepopulaSql(){
        String sqlString = "/../../../resources/script-popula-banco.sql";
        String sql = IOUtils.toString(new FileInputStream(sqlString), "UTF-8");
        getSession().createSQLQuery(sql);
    }

}