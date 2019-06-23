package com.ityang.basic.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.log4j2.Log4j2AbstractLoggerImpl;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@Slf4j
public class MybatisConfig {
    @Autowired
    private DataSource dataSource;


    private static SqlSessionFactoryBean bean;

    static {
        if(bean == null){
            bean = new SqlSessionFactoryBean();
        }
    }

    @Bean
    public SqlSessionFactory getSqlFactory() throws Exception {

        bean.setDataSource(dataSource);
        Properties properties = new Properties();
        properties.put("dbType", "oracle");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setVariables(properties);//配置Mybatis全局变量
        configuration.setLogImpl(StdOutImpl.class);//配置日志
//        bean.setConfigurationProperties(properties);
        bean.setConfiguration(configuration);
        bean.setDatabaseIdProvider(new DatabaseIdProvider() {
            private static final String DATABASE_MYSQL = "MySQL";
            private static final String DATABASE_POSTGRESQL = "PostgreSQL";
            private static final String DATABASE_ORACLE = "Oracle";
            private static final String DATABASE_DB2 = "DB2";

            @Override
            public void setProperties(Properties p) {
                System.out.println(p.getProperty("dbType"));
            }

            @Override
            public String getDatabaseId(DataSource dataSource) throws SQLException {
                Connection conn = dataSource.getConnection();
                String dbName = conn.getMetaData().getDatabaseProductName();
                String dbAlias = "";
                switch (dbName) {
                    case DATABASE_MYSQL:
                        dbAlias = "mysql";
                        break;
                    case DATABASE_POSTGRESQL:
                        dbAlias = "pg";
                        break;
                    case DATABASE_ORACLE:
                        dbAlias = "oracle";
                        break;
                    case DATABASE_DB2:
                        dbAlias = "db2";
                        break;
                    default:
                        break;
                }
                return dbAlias;
            }
        });
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate getTemplate(){

        SqlSessionTemplate template = null;
        try {
            template = new SqlSessionTemplate(bean.getObject());
        } catch (Exception e) {
            log.error("生成SqlSessionTemplate失败"+e);
            e.printStackTrace();
        }
        return template;
    }
}
