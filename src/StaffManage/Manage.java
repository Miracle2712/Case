package StaffManage;

public interface Manage<P> {

    void add(P p);

    void showStaffList();

    int findByName(String name);

    void findByStatusFullTime();

    void findByStatusPartTime();

    void editByName(String name, P p);

    void removeByName(String name);

    void updateStaffStatus(String name);

    void totalSalaryFullTime();

    void totalSalaryPartTime();





}
