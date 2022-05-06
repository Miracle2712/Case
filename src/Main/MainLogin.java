package Main;

import FileCSV.FileUserCSV;
import Model.Role;
import Model.User;
import StaffManage.ManageRole;
import StaffManage.ManageUser;

import java.io.IOException;
import java.util.Scanner;

public class MainLogin {

    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        ManageUser manageUser = new ManageUser();
        ManageRole manageRole = new ManageRole();
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Đăng nhập!");
            System.out.println("2. Đăng ký!");
            System.out.println("Nhập vào lựa chọn!");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Đăng nhập");
                    System.out.println("Nhập vào usn: ");
                    scanner.nextLine();
                    String usn = scanner.nextLine();
                    System.out.println("Nhập vào pass: ");
                    String pass = scanner.nextLine();
                    if (manageUser.login(usn, pass) == 1) {
                        int choice1 = -1;
                        while (choice1 != 0) {
                            System.out.println("Menu Customer");
                            System.out.println("0. Log out");
                            System.out.println("1. Xem thông tin");
                            System.out.println("2. Đổi pass");
                            if (ManageUser.currentUser.getRole().getName().equals("Admin")) {
                                System.out.println("3. Thêm sửa xoá Role");
                            }
                            System.out.println("Nhập vào lựa chọn!");
                            choice1 = scanner.nextInt();
                            switch (choice1) {
                                case 1:
                                    System.out.println("1. Xem thông tin");
                                    break;
                                case 2:
                                    System.out.println("Nhập pass mới");
                                    scanner.nextLine();
                                    String newPass = scanner.nextLine();
                                    ManageUser.currentUser.setPassword(newPass);
                                    FileUserCSV.writeToFile(manageUser.getUserList());
                                    break;
                                case 0:
                                    ManageUser.currentUser = null;
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Đăng Ký");
                    System.out.println("Nhập vào id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập vào usn: ");
                    String username = scanner.nextLine();
                    System.out.println("Nhập vào pass: ");
                    String password = scanner.nextLine();
                    String status = "1";
                    System.out.println("Nhập vào id role: ");
                    manageRole.findAll();
                    int idRole = scanner.nextInt();
                    Role role = manageRole.findById(idRole);
                    User user = new User(id, username, password, role, status);
                    manageUser.add(user);
                    FileUserCSV.writeToFile(manageUser.getUserList());
                    break;
                case 0:
                    System.out.println("Bye");
                    break;
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}