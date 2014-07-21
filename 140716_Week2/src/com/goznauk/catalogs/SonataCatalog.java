package com.goznauk.catalogs;

/**
 * Created by goznauk on 2014. 7. 21..
 */
public class SonataCatalog extends BaseCatalog {
    public SonataCatalog() {
        super();
        mName = "Sonata";
        mPrice = 3000;
    }

    public SonataCatalog(int number) {
        super(number);
        mName = "Sonata";
        mPrice = 3000;
    }
}
