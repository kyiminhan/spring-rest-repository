package com.kyiminhan.mm.spring.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = ConfigConstant.DB_PROP_SOURCE)
@ComponentScan(basePackages = { ConfigConstant.SCAN_PACKAGES_SPRING })
@EnableJpaRepositories(basePackages = { ConfigConstant.SCAN_PACKAGES_SPRING_REPO })
public class HibernateJPAConfig implements WebMvcConfigurer {

	/** The mysql driver. */
	@Value("${mysql.driver}")
	private String mysqlDriver;

	/** The jdbc URL. */
	@Value("${mysql.jdbcUrl}")
	private String jdbcURL;

	/** The user name. */
	@Value("${mysql.username}")
	private String userName;

	/** The password. */
	@Value("${mysql.password}")
	private String password;

	/** The hibernte dialet. */
	@Value("${hibernate.dialet}")
	private String hibernteDialet;

	/** The hibernate show sql. */
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	/** The hibernage hbm ddl auto. */
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernageHbmDdlAuto;

	/** The hibernate lazy load. */
	@Value("${hibernate.enable_lazy_load_no_trans}")
	private String hibernateLazyLoad;

	/** The hibernate C 3 p 0 min size. */
	@Value("${hibernate.c3p0.min_size}")
	private String hibernateC3p0MinSize;

	/** The hibernate C 3 p 0 max size. */
	@Value("${hibernate.c3p0.max_size}")
	private String hibernateC3p0MaxSize;

	/** The hibernate C 3 p 0 acquire increment. */
	@Value("${hibernate.c3p0.acquire_increment}")
	private String hibernateC3p0AcquireIncrement;

	/** The hibernate C 3 p 0 timeout. */
	@Value("${hibernate.c3p0.timeout}")
	private String hibernateC3p0Timeout;

	/** The hibernate C 3 p 0 max statements. */
	@Value("${hibernate.c3p0.max_statements}")
	private String hibernateC3p0MaxStatements;

	/** The hibernate connection pool size. */
	@Value("${hibernate.connection.pool_size}")
	private String hibernateConnectionPoolSize;

	/** The hibernate jdbc batch size. */
	@Value("${hibernate.jdbc.batch_size}")
	private String hibernateJdbcBatchSize;

	/** The hibernate jdbc fetch size. */
	@Value("${hibernate.jdbc.fetch_size}")
	private String hibernateJdbcFetchSize;

	/** The hibernate cache use second level cache. */
	@Value("${hibernate.cache.use_second_level_cache}")
	private String hibernateCacheUseSecondLevelCache;

	/** The hibernate cache region factory class. */
	@Value("${hibernate.cache.region.factory_class}")
	private String hibernateCacheRegionFactoryClass;

	// /** The hibernate current session context class. */
	// @Value("${hibernate.current_session_context_class}")
	// private String hibernateCurrentSessionContextClass;

	/** The hibernate cache use query cache. */
	@Value("${hibernate.cache.use_query_cache}")
	private String hibernateCacheUseQueryCache;

	@Bean
	public DataSource getDataSource() throws PropertyVetoException {
		final ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(this.mysqlDriver);
		dataSource.setJdbcUrl(this.jdbcURL);
		dataSource.setUser(this.userName);
		dataSource.setPassword(this.password);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(this.getDataSource());
		em.setPackagesToScan(new String[] { ConfigConstant.SCAN_PACKAGES_SPRING_ENTITY });
		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(this.additionalProperties());

		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties additionalProperties() {
		final Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, this.hibernteDialet);
		// properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS,
		// this.hibernateCurrentSessionContextClass);
		properties.put(AvailableSettings.SHOW_SQL, this.hibernateShowSql);
		properties.put(AvailableSettings.HBM2DDL_AUTO, this.hibernageHbmDdlAuto);
		properties.put(AvailableSettings.ENABLE_LAZY_LOAD_NO_TRANS, this.hibernateLazyLoad);
		// c3p0 connection Configuration
		properties.put(AvailableSettings.C3P0_MIN_SIZE, this.hibernateC3p0MinSize);
		properties.put(AvailableSettings.C3P0_MAX_SIZE, this.hibernateC3p0MaxSize);
		properties.put(AvailableSettings.C3P0_ACQUIRE_INCREMENT, this.hibernateC3p0AcquireIncrement);
		properties.put(AvailableSettings.C3P0_TIMEOUT, this.hibernateC3p0Timeout);
		properties.put(AvailableSettings.C3P0_MAX_STATEMENTS, this.hibernateC3p0MaxStatements);

		properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, this.hibernateJdbcBatchSize);
		properties.put(AvailableSettings.STATEMENT_FETCH_SIZE, this.hibernateJdbcFetchSize);
		properties.put(AvailableSettings.POOL_SIZE, this.hibernateConnectionPoolSize);
		properties.put(AvailableSettings.USE_SECOND_LEVEL_CACHE, this.hibernateCacheUseSecondLevelCache);
		properties.put(AvailableSettings.USE_QUERY_CACHE, this.hibernateCacheUseQueryCache);
		properties.put(AvailableSettings.CACHE_REGION_FACTORY, this.hibernateCacheRegionFactoryClass);
		return properties;
	}
}