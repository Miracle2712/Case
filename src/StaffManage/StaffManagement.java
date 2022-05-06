package StaffManage;

import FileCSV.FileStaff;
import Model.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffManagement implements Manage<Staff> {
    FileStaff fileStaff = new FileStaff();
    List<Staff> staffList = new ArrayList<>();

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public StaffManagement() {
    }

    @Override
    public void add(Staff staff) {
        staffList.add(staff);
    }

    @Override
    public void showStaffList() {
        for (int i = 0; i < staffList.size(); i++) {
            System.out.println(staffList.get(i));
        }
    }


    @Override
    public int findByName(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().equals(name)) {
                System.out.println(staffList.get(i));
                return i;
            }
        }
        System.out.println("không có trong danh bạ");
        return -1;
    }

    @Override
    public void findByNameFullTime() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().contains("fulltime")) {
                System.out.println(staffList.get(i));

            }
        }
    }


    @Override
    public void editByName(String name, Staff staff) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().equals(name)) {
                staffList.set(i, staff);
            }
        }
    }

    @Override
    public void removeByName(String name) {
        if (findByName(name) != -1) {
            staffList.remove(findByName(name));
        } else {
            System.out.println("Không tìm được trong danh sách");
        }
    }

    @Override
    public void updateStaffStatus(String name) {
        int index = findByName(name);
        if(index==-1){
            System.out.println("Ko tim thay");
        }else{
            staffList.get(index).setStatus("Nghi");
        }

    }

}
