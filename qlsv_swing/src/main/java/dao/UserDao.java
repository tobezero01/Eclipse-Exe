package dao;

import entity.User;

public class UserDao {
    public boolean checkUser(User user) {
        if (user != null) {
            if ("".equals(user.getUserName()) 
                    && "".equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
