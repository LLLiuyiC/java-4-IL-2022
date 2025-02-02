package com.example.java4il2022.week3.day14.demo2;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.Properties;

/**
 *  JPA
 *      1. DataSource
 *      2. entity manager factory
 *          entity manager1 -> Thread1
 *          entity manager2 -> Thread2
 *          entityManager.persist()
 *          entityManager.merge();
 *      3. JPQL
 *      4.
 *  Hibernate
 *      1. session factory
 *          session1 -> Thread1
 *          session2 -> Thread2
 *          session.save()
 *          session.saveOrUpdate();
 *
 *   lazy loading vs eager loading
 *   eager loading:
 *      Student stu = em.createQuery("select s from Student s");
 *      stu {teacher_student{...}} => 1 query
 *   lazy loading:
 *      Student stu = em.createQuery("select s from Student s");
 *      stu {teacher_stuent{empty}}
 *      stu.getTeacherStudent() => 2 queries
 *
 *      List<Student> stuList = ..
 *      for(Student stu: stuList) {
 *          stu.getTeacherStudent()
 *      } => N + 1 queries
 */
public class JPADemo {

    private DataSource getDataSource() {
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
//        dataSource.setDatabaseName("OrmDemo");
        dataSource.setUser("rq");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/OrmDemo");
        return dataSource;
    }

    private Properties getProperties() {
        final Properties properties = new Properties();
        properties.put( "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect" );
        properties.put( "hibernate.connection.driver_class", "org.postgresql.Driver" );
//        properties.put("hibernate.show_sql", "true");
        return properties;
    }

    private EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties ){
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan( "demo1" );
        em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
        em.setJpaProperties( hibernateProperties );
        em.setPersistenceUnitName( "demo-unit" );
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.afterPropertiesSet();
        return em.getObject();
    }

    public static void main(String[] args) {
        JPADemo jpaDemo = new JPADemo();
        DataSource dataSource = jpaDemo.getDataSource();
        Properties properties = jpaDemo.getProperties();
        EntityManagerFactory entityManagerFactory = jpaDemo.entityManagerFactory(dataSource, properties);
        EntityManager em = entityManagerFactory.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        Student s = new Student("bbb", "Y");
//        s.setId("10");
//        em.merge(s);
//        tx.commit();


//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Student> query = builder.createQuery(Student.class);
//        Root<Student> from = query.from(Student.class);
//        Predicate exp1 = builder.equal(from.get("first_name"), "xx");
//        Predicate exp2 = null;
//        if(!"xx".equals(null)) {
//            exp2 = builder.equal(from.get("last_name"), "xx");
//        }
//        Predicate exp3 = builder.or(exp1, exp2);
//        query.where(exp3);
//        Query q = em.createQuery(query);
    }
}
