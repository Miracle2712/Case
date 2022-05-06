package FileCSV;

import Model.Role;
import Model.User;
import StaffManage.ManageRole;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUserCSV {

    public static List<User> readFromFile() throws FileNotFoundException {
        ManageRole manageRole = new ManageRole();
        File roleFile = new File("C:\\Users\\PC\\Desktop\\CaseTest\\src\\FileCSV\\user.csv");
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(roleFile);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            } else {
                String arr[] = line.split(",");
                Role role = manageRole.findById(Integer.parseInt(arr[3]));
                User user = new User(Integer.parseInt(arr[0]), arr[1], arr[2], role, arr[4]);
                users.add(user);
            }
        }
        return users;
    }

    public static void writeToFile(List<User> list) throws FileNotFoundException {
        File roleFile = new File("C:\\Users\\PC\\Desktop\\CaseTest\\src\\FileCSV\\user.csv");
        PrintWriter printWriter = new PrintWriter(roleFile);
        printWriter.print("id,username,password,role,status\n");
        for ( int i=0; i< list.size(); i++) {
            printWriter.print(list.get(i));
        }
        printWriter.close();
    }
}