package dao;

import entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    private static List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public void updatePassword(User user,String newPassword) {
        for (User user1 : users) {
            if (user1.getUsername().equals(user.getUsername())){
                user1.setPassword(newPassword);
                break;
            }
        }
    }

    public boolean contains(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean contains(String username, String password){
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserByUsername(String username)  {
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}
