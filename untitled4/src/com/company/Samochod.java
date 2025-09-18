package com.company;

public final class Samochod extends Pojazd{
    private static Samochod INSTANCE;
    public final String kolor;
    public String numer;
    public int rokProdukcji;

    public Samochod(Builder builder){
        super(builder.numer2);
        this.kolor = builder.kolor;
        this.rokProdukcji = builder.rokProdukcji;
    }

//    public static Samochod getInstance(Builder builder){
//        if(INSTANCE == null || INSTANCE != null) {
//            INSTANCE = new Samochod(builder);
//        }
//        return INSTANCE;
//    }

    @Override
    public void jedz(){
        System.out.println("samochód jedzie");
    }

    public static class Builder {
        private int numer2;
        private String kolor;
        private int rokProdukcji;

        public Builder numer2(int numer2) {
            this.numer2 = numer2;
            return this;
        }

        public Builder kolor(String kolor) {
            this.kolor = kolor;
            return this;
        }

        public Builder rokProdukcji(int rokProdukcji) {
            this.rokProdukcji = rokProdukcji;
            return this;
        }

        public Samochod build() {
            return new Samochod(this);
        }
    }
}
