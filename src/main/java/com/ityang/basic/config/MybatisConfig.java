package com.ityang.basic.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class MybatisConfig {
    @Autowired
    private DataSource dataSource;


    @Bean
    public SqlSessionFactory getSqlFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        Properties properties = new Properties();
        properties.put("dbType", "oracle");
        bean.setConfigurationProperties(properties);
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
}
