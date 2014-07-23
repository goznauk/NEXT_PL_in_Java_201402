package com.goznauk;

import com.goznauk.Model.Employee;
import com.goznauk.Model.Manager;
import com.goznauk.Model.Secretary;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Manager());
        employees.add(new Manager());
        employees.add(new Secretary());

        for(Employee e : employees) {
            System.out.println(e.getAttribute());
        }
    }
}
