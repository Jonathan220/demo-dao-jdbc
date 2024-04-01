package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

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
    }
}