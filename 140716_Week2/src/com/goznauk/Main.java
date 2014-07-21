package com.goznauk;

import com.goznauk.catalogs.GenesisCatalog;
import com.goznauk.catalogs.GrandeurCatalog;
import com.goznauk.catalogs.SonataCatalog;

public class Main {

    public static void main(String[] args) {
        Company company = Company.getInstance();

        company.addCatalog(new SonataCatalog(3));
        company.addCatalog(new GrandeurCatalog(2));
        company.addCatalog(new GenesisCatalog(1));

        /*
         * Test Code for Duplicated add
         * company.addCatalog(new GrandeurCatalog(2));
         */

        System.out.println("The Sum Cost of Company's Car : " + company.getAllPrice());
    }
}
