package Main;

import FileCSV.FileStaff;
import FileCSV.FileUserCSV;
import Model.Role;
import Model.Staff;
import Model.User;
import StaffManage.ManageRole;
import StaffManage.ManageUser;
import StaffManage.StaffManagement;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException  {

        StaffManagement staffManagement = new StaffManagement();

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
                        int choice1 = 1;

                        while (choice1!=10) {
                            System.out.println("--------------MENU-----------------");
                            System.out.println("Vui long nhap lua chon");
                            System.out.println("" +
                                    "0.  Hiển thị tất cả nhân viên\n"+
                                    "1.  Thêm\n" +
                                    "2.  Tìm kiếm\n" +
                                    "3.  In ra danh sách nhân viên fulltime\n"+
                                    "4.  In ra danh sách nhân viên parttime\n"+
                                    "5.  Sửa\n"+
                                    "6.  Xóa\n"+
                                    "7.  Đổi trạng thái\n"+
                                    "8.  Lương của nhân viên fulltime\n"+
                                    "9.  Lương của nhân viên parttime\n"+
                                    "10. ghi file\n"+
                                    "11  đọc file\n"+
                                    "12. Thoát"
                            );
                            choice1= scanner.nextInt();

                            switch (choice1) {
                                case 0:
                                    staffManagement.showStaffList();
                                    break;
                                case 1:
                                    Scanner sc = new Scanner(System.in);
                                    System.out.println("Nhập tên nhân viên") ;
                                    String ten = sc.nextLine();

                                    sc = new Scanner(System.in);
                                    System.out.println("Nhập kiểu nhân viên");
                                    String kieuNhanVien = sc.nextLine();

                                    sc= new Scanner(System.in);
                                    System.out.println("Nhập trạng thái ");
                                    String trangThai = sc.nextLine();

                                    sc= new Scanner(System.in);
                                    System.out.println("Nhập lương ");
                                    int luong = sc.nextInt();

                                    Staff staff1 = new Staff(ten, kieuNhanVien, trangThai,luong);
                                    staffManagement.add(staff1);
                                    staffManagement.showStaffList();
                                    break;
                                case 2:
                                    sc = new Scanner(System.in);
                                    System.out.println("Nhập tên nhân viên cần tìm");
                                    String timNhanVien = sc.nextLine();
                                    staffManagement.findByName(timNhanVien);
                                    break;
                                case 3:
                                    System.out.println("Danh sách nhân viên fulltime");
                                    staffManagement.findByStatusFullTime();
                                    break;

                                case 4:
                                    System.out.println("Danh sách nhân viên parttime");
                                    staffManagement.findByStatusPartTime();
                                    break;

                                case 5:
                                    sc = new Scanner(System.in);
                                    System.out.println("NHân viên cần sửa thông tin");
                                    String nhanVien = sc.nextLine();

                                    sc = new Scanner(System.in);
                                    System.out.println("Nhập tên nhân viên");
                                    ten = sc.nextLine();

                                    sc = new Scanner(System.in);
                                    System.out.println("Nhập kiểu nhân viên");
                                    kieuNhanVien = sc.nextLine();

                                    sc= new Scanner(System.in);
                                    System.out.println("Nhập trạng thái ");
                                    trangThai = sc.nextLine();

                                    sc= new Scanner(System.in);
                                    System.out.println("Nhập lương ");
                                    luong = sc.nextInt();

                                    staffManagement.editByName(nhanVien, new Staff(ten, kieuNhanVien, trangThai, luong));

                                    staffManagement.showStaffList();
                                    break;


                                case 6:
                                    sc = new Scanner(System.in);
                                    System.out.println("Nhân viên cần xóa");
                                    String xoa = sc.nextLine();
                                    staffManagement.removeByName(xoa);
                                    break;

                                case 7:
                                    sc = new Scanner(System.in);
                                    System.out.println("Nhập tên cần chuyển đổi");
                                    String update = sc.nextLine();
                                    staffManagement.updateStaffStatus(update);
                                    break;
                                case 8:
                                    staffManagement.totalSalaryFullTime();
                                    break;

                                case 9:
                                    staffManagement.totalSalaryPartTime();
                                    break;
                                case 10:
                                    FileStaff.writeToFile(staffManagement.getStaffList());
                                    break;
                                case 11:
                                    FileStaff.readFromFile();
                                    break;
                                case 12:
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