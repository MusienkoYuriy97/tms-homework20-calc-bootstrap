package dao;


import entity.User;
import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void saveUser(User user) ;
    boolean contains(String username);
    boolean contains(String username, String password);
    User getUserByUsername(String username);
    void updatePassword(User user,String newPassword);
}
