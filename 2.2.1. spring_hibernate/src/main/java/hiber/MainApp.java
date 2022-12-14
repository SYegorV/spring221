package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("catherine", "bell", "catherinebell@gmail.com", new Car("Bentley", 8888)));
      userService.add(new User("amanda", "green", "amandagreen@gmail.com", new Car("BMW", 8448)));
      userService.add(new User("ruby", "kelly", "rubykelly@gmail.com", new Car("Tesla", 884488)));
      userService.add(new User("anastasia", "perry", "anastasiaperry@gmail.com", new Car("Chevrolet", 3384833)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getUserCar().toString());
         System.out.println();
      }

      System.out.println(userService.usersByCar("Bentley", 8888));

      context.close();
   }
}
