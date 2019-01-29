package pl.michalskrzypek.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@ComponentScan(basePackages = { "pl.michalskrzypek.entity" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshop";
	private final static String DATABASE_USERNAME = "admin";
	private final static String DATABASE_PASSWORD = "admin";
	// Hibernate needs to distinguish what syntax(dialect) to use for specific
	// database.
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";

	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		// Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;

	}
	// we use this method to connect database with our entity classes, to set
	// properties for Hibernate (look below) and then pack all of this into session
	// factory that manage the whole connection between db and entities (by using
	// hibernate by the way)
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "pl.michalskrzypek.entity" });
		sessionFactory.setHibernateProperties(getHibernateProperties());

		return sessionFactory;
	}

	// Returns Hibernate properties such as dialect, whether to show sql query that
	// has been used, whether to show this query in a sql format etc.
	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

/*		properties.put("hibernate.hbm2ddl.auto", "update");*/

		return properties;
	}

	// transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
/*	 @Bean
	    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
	        return new HibernateTemplate(sessionFactory);
	    }*/

}