package ru.downloadfiles.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.downloadfiles.models.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 12.12.2020
 * HibernateConfig
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@WebListener
public class HibernateConfigListener implements ServletContextListener {

    Session session;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext ctx = servletContextEvent.getServletContext();

        Configuration configuration = new Configuration();

        String dbUrl = ctx.getInitParameter("dbUrl");
        String dbUsername = ctx.getInitParameter("dbUser");
        String dbPassword = ctx.getInitParameter("dbPassword");
        String driverClassName = ctx.getInitParameter("dbDriver");

        configuration.setProperty("hibernate.connection.url", dbUrl);
        configuration.setProperty("hibernate.connection.username", dbUsername);
        configuration.setProperty("hibernate.connection.password", dbPassword);
        configuration.setProperty("hibernate.connection.driver_class", driverClassName);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addResource("User.hbm.xml");
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.show_sql", "true");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.session = sessionFactory.openSession();
        ctx.setAttribute("Session", session);

    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener destroyed");
    }
}
