package com.company;

public class Pojazd {
    public int numer;
    protected int numer2;

    public Pojazd() {
        numer2 = 100;
    }

    public Pojazd(int numer2) {
        this.numer2 = numer2;
    }

    public void jedz(){
        System.out.println("jedzie");
    }
}
