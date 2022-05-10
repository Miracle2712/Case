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

public class MainLogin {

    public static void main(String[] args) throws IOException  {
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
                        int choice1 = 1;

                        while (choice1!=10) {
                            System.out.println("--------------MENU-----------------");
                            System.out.println("Vui long nhap lua chon");
                            System.out.println("" +
                                    "0. Hiển thị tất cả nhân viên\n"+
                                    "1. Thêm\n" +
                                    "2. Tìm kiếm\n" +
                                    "3. In ra danh sách nhân viên full time\n"+
                                    "4. Sửa\n"+
                                    "5. Xóa\n"+
                                    "6. Đổi trạng thái\n"+
                                    "7. Tính tổng lương của phòng kinh doanh\n"+
                                    "8. ghi file\n"+
                                    "9. đọc file\n"+
                                    "10.Thoát"



                            );
                            choice1= scanner.nextInt();

                            StaffManagement staffManagement = new StaffManagement();
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
                                    String luong = sc.nextLine();

                                    Staff staff1 = new Staff(ten, kieuNhanVien, trangThai, luong);
                                    staffManagement.add(staff1);
                                    break;
                                case 2:
                                    sc = new Scanner(System.in);
                                    System.out.println("Nhân viên cần tìm");
                                    String timNhanVien = sc.nextLine();
                                    staffManagement.findByName(timNhanVien);
                                    break;
                                case 3:
                                    System.out.println("Nhân viên full time cần tìm");
                                    staffManagement.findByNameFullTime();
                                    break;

                                case 4:
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
                                    luong = sc.nextLine();

                                    staffManagement.editByName(nhanVien, new Staff(ten, kieuNhanVien, trangThai, luong));

                                    staffManagement.showStaffList();
                                    break;


                                case 5:
                                    sc = new Scanner(System.in);
                                    System.out.println("Nhân viên cần xóa");
                                    String xoa = sc.nextLine();
                                    staffManagement.removeByName(xoa);
                                    break;

                                case 6:
                                    sc = new Scanner(System.in);
                                    System.out.println("Nhập tên cần chuyển đổi");
                                    String update = sc.nextLine();
                                    staffManagement.updateStaffStatus(update);
                                    break;
                                case 7:

                                case 8:
                                    FileStaff.writeToFile(staffManagement.getStaffList());
                                    break;
                                case 9:
                                    FileStaff.readFromFile();
                                    break;
                                case 10:

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