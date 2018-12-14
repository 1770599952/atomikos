package com.atomikos.datasoureconfig;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.atomikos.dao1*",sqlSessionTemplateRef = "sqlSessionTemplateTest1")
public class DataSourceTest1Config {

    @Bean(name = "dataSourceTest1")
    public DataSource dataSourceCar(DataSourceTest1Properties dataSourceTest1Properties){
        DruidXADataSource dataSource = new DruidXADataSource();
        BeanUtils.copyProperties(dataSourceTest1Properties,dataSource);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(dataSource);
        xaDataSource.setUniqueResourceName("dataSourceTest1");
        return xaDataSource;
    }


    @Bean(name = "sqlSessionFactoryTest1")
    public SqlSessionFactory sqlSessionFactoryCar(@Qualifier("dataSourceTest1") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.atomikos.dao1");
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplateTest1")
    public SqlSessionTemplate sqlSessionTemplateCar(
            @Qualifier("sqlSessionFactoryTest1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
