package hrq.multidatasorce.datasourcemulti2.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "hrq.multidatasorce.datasourcemulti2.dao.mapper.slave", sqlSessionTemplateRef  = "slaveSqlSessionTemplate")
public class SlaveDataSourceConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${multiple.datasource.slave.url}")
    private String dbUrl;
    @Value("${multiple.datasource.slave.username}")
    private String username;
    @Value("${multiple.datasource.slave.password}")
    private String password;
    @Value("${multiple.datasource.slave.driver-class-name}")
    private String driverClassName;
    @Value("${multiple.datasource.slave.initialSize}")
    private Integer initialSize;
    @Value("${multiple.datasource.slave.minIdle}")
    private Integer minIdle;
    @Value("${multiple.datasource.slave.maxActive}")
    private Integer maxActive;
    @Value("${multiple.datasource.slave.maxWait}")
    private Integer maxWait;
    @Value("${multiple.datasource.slave.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;
    @Value("${multiple.datasource.slave.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;
    @Value("${multiple.datasource.slave.validationQuery}")
    private String validationQuery;
    @Value("${multiple.datasource.slave.logAbandoned}")
    private boolean logAbandoned;
    @Value("${multiple.datasource.slave.removeAbandonedTimeout}")
    private Integer removeAbandonedTimeout;
    @Value("${multiple.datasource.slave.removeAbandoned}")
    private boolean removeAbandoned;
    @Value("${multiple.datasource.slave.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${multiple.datasource.slave.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${multiple.datasource.slave.testOnReturn}")
    private boolean testOnReturn;
    @Value("${multiple.datasource.slave.connectionProperties}")
    private String connectionProperties;
    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "slave.spring.datasource")
    public DataSource testDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setLogAbandoned(logAbandoned);
        datasource.setRemoveAbandoned(removeAbandoned);
        datasource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        datasource.setConnectionProperties(connectionProperties);
        //  return DataSourceBuilder.create().build();
        return datasource;
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/slave/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("slaveDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slaveSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
