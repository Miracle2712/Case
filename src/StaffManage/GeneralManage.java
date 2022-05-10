package StaffManage;

public interface GeneralManage<T> {
    void add(T t);
    T findById(int id);
    void findAll();
    int findIndexById(int id);
}