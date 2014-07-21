package com.goznauk.catalogs;

/**
 * Created by goznauk on 2014. 7. 21..
 */
public class BaseCatalog {
    protected String mName;
    protected int mPrice;
    protected int mNumber;

    public BaseCatalog() {
        mNumber = 0;
    }

    public BaseCatalog(int number) {
        this.mNumber = number;
    }

    public String getName() {
        return mName;
    }

    public int getNum() {
        return mNumber;
    }

    public void addNum(int number) {
        this.mNumber += number;
    }

    public int getSum() {
//        System.out.println(mName + " : getSum called");
        return mPrice * mNumber;
    }
}
