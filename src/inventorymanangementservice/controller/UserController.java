package inventorymanangementservice.controller;

import inventorymanangementservice.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList;

    public UserController() {
        this.userList = new ArrayList<>();
    }

    public User getUser(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                userList.remove(user);
                return;
            }
        }
    }

}
