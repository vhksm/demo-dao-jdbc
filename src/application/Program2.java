package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();


        /*System.out.println("\n === TEST 1: department insert ===");
        Department newDepartment = new Department(null, "Ghost Contracts");
        departmentDao.insert(newDepartment);
        System.out.println("Insert done! Success, new ID: " + newDepartment.getId());*/

        System.out.println("\n ==== TEST 2: department findById ====");
        Department dep = departmentDao.findById(7);
        System.out.println(dep);

        System.out.println("\n ==== TEST 3: department findAll");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list){
            System.out.println(obj);
        }

        System.out.println("\n === TEST 4: department update");
        System.out.println("Type what id you would like to change: ");
        int id = sc.nextInt();
        dep = departmentDao.findById(id);
        dep.setName("Food");
        departmentDao.update(dep);
        System.out.println("Update succeeded!");

        System.out.println("\n === TEST 5: department deletById");
        System.out.println("Type what id you would like to delete: ");
        id = sc.nextInt();
        dep = departmentDao.findById(id);
        if (dep == null){
            System.out.println("Id does not exist!");
            return;
        }
        departmentDao.deleteById(id);
        System.out.println("Delete completed! ");

        sc.close();
    }
}
