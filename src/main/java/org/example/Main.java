package org.example;

import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department departamento = new Department(1, "books");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, departamento);
        System.out.println(seller);
    }
}