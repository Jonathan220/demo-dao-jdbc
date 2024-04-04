package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.DepartmentDao;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDAO();

        System.out.println("Teste findbyID");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();
        System.out.println("Teste findByDepertment");

        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("Teste findAll");

        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("Teste insert");

        Seller obj = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(obj);
        System.out.println("Inserted! New id = " + obj.getId());

        System.out.println();
        System.out.println("Teste update");

        seller = sellerDao.findById(1);
        seller.setName("Martha Weiner");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println();
        System.out.println("Teste Delete");
        System.out.print("Enter id for delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted completed");

        System.out.println("Teste Como department =========================");
        System.out.println("Teste findAll");
        System.out.println(departmentDao.findAll());

        System.out.println();
        System.out.println("Teste findById");
        System.out.println(departmentDao.findById(1));

        System.out.println();
        System.out.println("Teste insert");
        Department newDepartment = new Department(null, "Cysecurity");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! new id = " + newDepartment.getId());

        System.out.println("Teste update");
        Department updatedDepartment = departmentDao.findById(3);
        updatedDepartment.setName("Moda");
        departmentDao.update(updatedDepartment);
        System.out.println("updated Completed");

        System.out.println();
        System.out.println("Teste delete");
        System.out.println("Enter id for delete departement");
        int idDepartment = sc.nextInt();
        departmentDao.deleteById(idDepartment);
        System.out.println("Deleted completed");

        sc.close();
    }
}