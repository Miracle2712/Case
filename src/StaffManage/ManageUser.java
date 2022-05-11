package StaffManage;

import FileCSV.FileUserCSV;
import Model.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ManageUser implements GeneralManage<User> {
    List<User> userList = new ArrayList<>();
    public static User currentUser = null;

    public ManageUser() throws FileNotFoundException {
        userList = FileUserCSV.readFromFile();
    }

    public int login(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return 1;
            }
        }
        return 0;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public User findById(int id) {
        return userList.get(findIndexById(id));
    }

    @Override
    public void edit(int id, User user) {

    }

    @Override
    public void delete(int id) {

    }


    @Override
    public void findAll() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}