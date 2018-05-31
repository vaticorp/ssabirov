package context;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.carsstorage.model.Car;
import ru.job4j.carsstorage.model.Engine;
import ru.job4j.carsstorage.model.Gearbox;
import ru.job4j.carsstorage.model.Transmission;

public class HibernateTest {

    public static void addCar() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Engine engine = new Engine();
            engine.setCapacity("1.6v");
            session.save(engine);
            Transmission transmission = new Transmission();
            transmission.setDescription("CVT");
            session.save(transmission);
            Gearbox gearbox = new Gearbox();
            gearbox.setType("gidravlic");
            session.save(gearbox);
            Car car = new Car();
            car.setModel("VESTA");
            car.setEngine(engine);
            car.setGearbox(gearbox);
            car.setTransmission(transmission);
            session.save(car);
        } finally {
            transaction.commit();
            session.close();
            factory.close();
        }
    }

    public static void getCar() {
         SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Car car = session.get(Car.class, (long)6);
            System.out.println(car);
        } finally {
            transaction.commit();
            session.close();
            factory.close();
        }
    }

    public static void main(String[] args) {
        //HibernateTest.addCar();
        HibernateTest.getCar();
    }
}
