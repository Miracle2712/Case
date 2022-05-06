package FileCSV;

import Model.Staff;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FileStaff {
    public static void writeToFile (List<Staff> staffList) throws IOException {
        // Chuyên để đọc File
        File file = new File("staffout.csv");
        file.createNewFile();
        PrintWriter pw = new PrintWriter(file);
        String str = "tên, kiểu nhân viên, trạng thái, lương" +"\n";
        for (Staff i: staffList) {
            str += i.getName()  +","+ i.getType() +","+ i.getStatus() +","+ i.getSalary() +"\n";
        }
        pw.write(str);
        pw.close();
    }

    // Chuyên ghi file
    public static void readFromFile (List<Staff> staffList) throws IOException {
        File file = new File("staffout.csv");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String a = sc.nextLine();
            System.out.println(a);
        }
        sc.close();
    }
}

