package com.simple.testing.infrasturcture.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;

/**
 * @author chenkangkang
 * @date 2022/1/24 4:20 PM
 **/
@Configuration
@MapperScan({"com.simple.testing.infrasturcture.presistence"})
public class DbConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.database-name}")
    private String dataname;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        // h2 内存数据库 内存模式连接配置
        String url = "jdbc:h2:file:" + System.getProperty("user.dir") + File.separator + "datasource" + File.separator + dataname;
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = {"sqlSessionFactory"})
    @Autowired
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        //http://localhost:8080/h2-console/test.do
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setGlobalConfig(globalConfiguration());
        return bean.getObject();
    }


    @Bean
    public GlobalConfig globalConfiguration() {
        GlobalConfig conf = new GlobalConfig();
        conf.setDbConfig(mybatisPlusDbConfig());
        return conf;
    }

    @Bean
    public GlobalConfig.DbConfig mybatisPlusDbConfig() {
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        return dbConfig;
    }
}
