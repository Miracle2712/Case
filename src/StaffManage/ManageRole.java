package StaffManage;

import FileCSV.FileRoleCSV;
import Model.Role;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ManageRole implements GeneralManage<Role> {
    List<Role> roleList = new ArrayList<Role>();

    public ManageRole() throws FileNotFoundException {
        roleList = FileRoleCSV.readFromFile();
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public void add(Role role) {
        roleList.add(role);
    }

    @Override
    public Role findById(int id) {
        return roleList.get(findIndexById(id));
    }

    @Override
    public void edit(int id, Role role) {
        roleList.set(findIndexById(id), role);
    }

    @Override
    public void delete(int id) {
        roleList.remove(findIndexById(id));
    }

    @Override
    public void findAll() {
        for (int i=0; i<roleList.size(); i++) {
            System.out.println(roleList.get(i));
        }
    }

    @Override
    public int findIndexById(int id) {
        for (int i=0; i<roleList.size(); i++) {
            if (roleList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}