package com.ngechu;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class TransactionHelper {

private static SessionFactory sessionFactory;
	
	
	
	private static SessionFactory createSessionFactory() {
		
		
		Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/tracom ? useSSL=false");
        properties.setProperty(Environment.USER, "root");
        properties.setProperty(Environment.PASS, "ngechumunga");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
       
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

       
		
		Configuration configuration=new Configuration().setProperties(properties).addAnnotatedClass(TransactionBean.class);
		
		
		
		ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
			
		return sessionFactory;
		
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null)
			sessionFactory=createSessionFactory();
		return sessionFactory;
	}

	
}
