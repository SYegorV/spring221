package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {

   void add(User user);

   List<User> usersByCar(String carName, int carSeries);

   List<User> listUsers();
}
