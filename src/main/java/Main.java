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


//        User user = User.builder()
//                .name("Roma")
//                .age(20)
//                .sex("Male")
//                .surName("Sydor")
//                .email("email@mail.com").build();
//        manager.persist(user);
//        user = User.builder()
//                .name("Bohdan")
//                .age(19)
//                .sex("Male")
//                .surName("Prots")
//                .email("email1@mail.com").build();
//        manager.persist(user);
//        user = User.builder()
//                .name("Max")
//                .age(19)
//                .sex("Male")
//                .surName("Andrysuk")
//                .email("email2@mail.com").build();
//        manager.persist(user);
//        user = User.builder()
//                .name("Anna")
//                .age(20)
//                .sex("Female")
//                .surName("Lucky")
//                .email("email3@mail.com").build();
//        manager.persist(user);

        System.out.println("One user by id " + manager.find(User.class, 3).toString());


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

        Query select_u_from_user_u = manager.createQuery("select u from User u");
        List resultList = select_u_from_user_u.getResultList();
        System.out.println("\n\nGet all users : ");
        for (Object o : resultList) {
            System.out.println("User " + o);
        }


        Query query = manager.createQuery("select u from User u where  u.sex like 'Female'");
        System.out.println("All Female user: \n" + query.getResultList());

//        Passport passport = Passport
//                .builder()
//                .serialNumber("_1_#")
//                .build();
//        manager.persist(passport);
//        passport.setUser(manager.find(User.class,1));
//
//        Passport passport = Passport
//                .builder()
//                .serialNumber("_2_$")
//                .build();
//        manager.persist(passport);
//        passport.setUser(manager.find(User.class,2));
//        Passport passport = Passport
//                .builder()
//                .serialNumber("_2_$")
//                .build();
//        manager.persist(passport);
//        passport.setUser(manager.find(User.class,2));

//       Passport passport = Passport
//                .builder()
//                .serialNumber("_3_%")
//                .build();
//        manager.persist(passport);
//        passport.setUser(manager.find(User.class,3));
//
//        Passport passport = Passport
//                .builder()
//                .serialNumber("_4_&")
//                .build();
//        manager.persist(passport);
//        passport.setUser(manager.find(User.class,4));
//


//        Passport passport = Passport.builder().serialNumber("asddas123").build();
//        manager.persist(passport);
//        User user = manager.find(User.class, 1);
//        passport.setUser(user);


        TypedQuery<User> query1 = manager.createQuery("select  u from User u left  join  fetch  u.passport", User.class);
        List<User> userList = query1.getResultList();
        System.out.println("\n\nPassport + User : ");
        for (User user : userList) {
            System.out.println(user + " " + user.getPassport());
        }

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

//        Car car = Car.builder()
//                .mark("4")
//                .model("Lada")
//                .countOfDoors(4)
//                .engineValue(400)
//                .maxSpeed(120)
//                .serialNumber(123)
//                .price(1000)
//                .year(1999)
//                .build();
//        manager.persist(car);
//        Car car1 = Car.builder()
//                .mark("S")
//                .model("Tesla")
//                .countOfDoors(4)
//                .engineValue(1000)
//                .maxSpeed(400)
//                .serialNumber(321)
//                .price(100000)
//                .year(2017)
//                .build();
//        manager.persist(car1);
//        Car car2 = Car.builder()
//                .mark("X")
//                .model("Tesla")
//                .countOfDoors(4)
//                .engineValue(1000)
//                .maxSpeed(380)
//                .serialNumber(1213)
//                .price(80000)
//                .year(2016)
//                .build();
//        manager.persist(car2);
//        Car car3 = Car.builder()
//                .mark("Roadster")
//                .model("Tesla")
//                .countOfDoors(2)
//                .engineValue(9000)
//                .maxSpeed(500)
//                .serialNumber(666)
//                .price(150000)
//                .year(2018)
//                .build();
//        manager.persist(car3);
//        Car car4 = Car.builder()
//                .mark("i3")
//                .model("BMW")
//                .countOfDoors(2)
//                .engineValue(1000)
//                .maxSpeed(320)
//                .serialNumber(11223)
//                .price(40000)
//                .year(2017)
//                .build();
//        manager.persist(car4);
//        Car car5 = Car.builder()
//                .mark("i8")
//                .model("BMW")
//                .countOfDoors(2)
//                .engineValue(4000)
//                .maxSpeed(400)
//                .serialNumber(12349123)
//                .price(120000)
//                .year(2015)
//                .build();
//        manager.persist(car5);
//        Car car6 = Car.builder()
//                .mark("Q8")
//                .model("Audi")
//                .countOfDoors(4)
//                .engineValue(1200)
//                .maxSpeed(300)
//                .serialNumber(990)
//                .price(132000)
//                .year(2018)
//                .build();
//        manager.persist(car6);
//        Car car7 = Car.builder()
//                .mark("R8")
//                .model("Audi")
//                .countOfDoors(2)
//                .engineValue(2000)
//                .maxSpeed(510)
//                .serialNumber(6969)
//                .price(70000)
//                .year(2014)
//                .build();
//        manager.persist(car7);
//
//        car.setUser( manager.find(User.class, 3));
//        car1.setUser( manager.find(User.class, 1));
//        car1.setUser( manager.find(User.class, 4));
//        car2.setUser( manager.find(User.class, 2));
//        car4.setUser( manager.find(User.class, 2));
//        car5.setUser( manager.find(User.class, 2));
//        car3.setUser( manager.find(User.class, 1));
//        car5.setUser( manager.find(User.class, 4));
//        car6.setUser( manager.find(User.class, 1));
//        car7.setUser( manager.find(User.class, 2));
//        car2.setUser( manager.find(User.class, 3));
//        car4.setUser( manager.find(User.class, 2));
//        car1.setUser( manager.find(User.class, 4));
//        car2.setUser( manager.find(User.class, 1));



//        lada.setUser(user);
//        amg.setUser(user);


//        Wash newWash = Wash.builder().titile("NewWash").build();
//        Wash newWash1 = Wash.builder().titile("MR Proper").build();
//        manager.persist(newWash);
//        manager.persist(newWash1);


        //error
//        List<Wash> select_w_from_wash_ = manager.createQuery("select w from Wash w ", Wash.class).getResultList();
//        Car car = manager.find(Car.class, 1);
//        car.setWashes(select_w_from_wash_);
//        manager.merge(car);


        List<Wash> washes = manager.createQuery("select  w from  Wash w", Wash.class).getResultList();
        System.out.println("\n\nWashes : \n" + washes);

//        Wash wash = manager.find(Wash.class, 1);
//
//        List<Car> cars = manager.createQuery("select c from Car c").getResultList();
//        wash.setCars(cars);
        List<Car> cars = manager.createQuery("select c from Car c").getResultList();
        Iterator<Car> iterator = cars.iterator();
        System.out.println("\n\nAll  cars :");
        while (iterator.hasNext()) {
            Car next = iterator.next();
            System.out.println(next);
        }

        Wash wash1 = manager.find(Wash.class, 1);
        Wash wash2 = manager.find(Wash.class, 2);

//        List resultList1 = manager.createQuery("select c from  Car c where c.price<100000").getResultList();
//        wash1.setCars(resultList1);
//
//        List resultList2 = manager.createQuery("select c from  Car c where c.price>100000").getResultList();
//        wash2.setCars(resultList2);

//        List resultList = manager.createQuery("select distinct u from User u left join  fetch  u.passport left join fetch u.cars").getResultList();
//        for (Object o : resultList) {
//            System.out.println(o);
//        }

        List resultList3 = manager.createQuery("select  distinct  u from User  u left  join  fetch  u.passport left  join fetch  u.cars").getResultList();
        System.out.println("\n\nResult :\n");
        for (Object o : resultList3) {
            System.out.println(o);
        }
//
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }

}
