package com.goznauk;

import com.goznauk.catalogs.BaseCatalog;

import java.util.*;

/**
 * Created by goznauk on 2014. 7. 21..
 */
public class Company {
    private static Company mCompany = new Company();
    private List<BaseCatalog> catalogs;

    public static Company getInstance() {
        if(mCompany == null) { mCompany = new Company(); }
        return mCompany;
    }

    public Company() {
        catalogs = new ArrayList<BaseCatalog>();
    }

    public void addCatalog(BaseCatalog catalog) {
        for(BaseCatalog cat : catalogs) {
            if(cat.getName() == catalog.getName()) {
                cat.addNum(catalog.getNum());
                return;
            }
        }
        catalogs.add(catalog);
    }

    public int getAllPrice() {
        int sum = 0;

        for(BaseCatalog catalog : catalogs) {
            sum += catalog.getSum();
          //  System.out.println(catalog.getName() + "'s cost added : " + sum);
        }
        return sum;
    }
}
