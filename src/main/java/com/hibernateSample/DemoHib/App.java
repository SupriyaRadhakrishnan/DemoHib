package com.hibernateSample.DemoHib;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
    	AlienName aname = new AlienName();
    	aname.setfName("John");
    	aname.setlName("Rodriguez");
    	aname.setmName("Eddie");
        Alien alien1 = new Alien();
        alien1.setAid(102);
        alien1.setAname(aname);
        alien1.setColor("Blue");
        
        /*Session is inside hibernate.We need to add hibernate dependency in pom.xml. 
         * import the org.hibernate.Session to use Session
         * Session is a Interface , hence cannot create an Object.
         * We create a Configuration Object which in turn creates a SessionFactory Object.
         * OpenSession is a method that gives a Object of Session.
         * .configure helps to get db info from the hibernate.cfg.xml(Default file name)
         */
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class); 
        
        
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory  sessionFactory = cfg.buildSessionFactory(reg);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        //Get id used to fetch data
        //Alien alien  = (Alien) session.get(Alien.class,102);
        //below 2 lines in for inserting data in to the table 
        session.save(alien1);
        tx.commit();
        
       // System.out.println(alien);
    }
}
