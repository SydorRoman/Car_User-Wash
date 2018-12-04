import entity.Car;
import entity.Passport;
import entity.User;
import entity.Wash;
import javafx.scene.chart.CategoryAxis;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();


//        User vasya = User.builder().name("vasya").build();
//        User bodia = User.builder().name("bodia").build();
//        User roma = User.builder().name("roma").build();
//        manager.persist(vasya);
//        manager.persist(roma);
//        manager.persist(bodia);


//        User user = manager.find(User.class, 1);
//        System.out.println(user.toString());

        //Query select_u_from_user_u = manager.createQuery("select u from User u");
        //manager.createQuery("select u.id from User u");
        //manager.createQuery("select u.name from User u");
        //manager.createQuery("select u.name from User u where u.id > 3");
        //manager.createQuery("select u.name from User u where u.id > 3");
//        TypedQuery<User> query = manager.createQuery("select u from User u ", User.class);
//        List<User> resultList = query.getResultList();
//
//        for (User user : resultList) {
//            System.out.println(user);
//        }


//        Passport passport = Passport.builder().serialNumber("asddas123").build();
//
//        manager.persist(passport);
//
//        User user = manager.find(User.class, 1);
//        passport.setUser(user);

//        TypedQuery<User> query = manager.createQuery("select u from User u left join fetch u.passport", User.class);
//        List<User> resultList = query.getResultList();
//        for (User user : resultList) {
//            System.out.println(user + " " + user.getPassport());
//        }


//          User user = manager.find(User.class, 1);
//        Car lada = Car.builder().model("LADA").build();
//        Car amg = Car.builder().model("AMG").build();
//        manager.persist(lada);
//        manager.persist(amg);
//
//        lada.setUser(user);
//        amg.setUser(user);


//        Wash newWash = Wash.builder().titile("NewWash").build();
//        Wash newWash1 = Wash.builder().titile("MR Pro").build();
//        manager.persist(newWash);
//        manager.persist(newWash1);


        //error
//        List<Wash> select_w_from_wash_ = manager.createQuery("select w from Wash w ", Wash.class).getResultList();
//        Car car = manager.find(Car.class, 1);
//        car.setWashes(select_w_from_wash_);
//        manager.merge(car);

//        Wash wash = manager.find(Wash.class, 1);
//
//        List<Car> cars = manager.createQuery("select c from Car c").getResultList();
//        wash.setCars(cars);


        List resultList = manager.createQuery("select distinct u from User u left join  fetch  u.passport left join fetch u.cars").getResultList();
        for (Object o : resultList) {
            System.out.println(o);
        }

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }

}
