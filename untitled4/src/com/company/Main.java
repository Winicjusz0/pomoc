package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Election election = new Election();
//        //election.populateCandidates("kandydaci.txt");
//        election.populate("1.csv");
//        ElectionTurn secondTurn = election.getSecondTurn();
//        if (secondTurn == null){
//            System.out.println("Zwycięzca pierwszej tury:");
//        }
//        else{
//            System.out.println("Druga tura");
//        }
//        //ElectionTurn electionTurn = new ElectionTurn(election.getCandidate());
//        //electionTurn.populate("1.csv");
//        //Vote wyniki = electionTurn.summarize();
////        Vote vote = new Vote();
////        election.populate("1.csv", vote);
////        System.out.println(election.getSecondTurn().summarize());
////        List<String> location = new ArrayList<>();
////        location.add("lubelskie");
////        Vote wynikiLubelskie = election.getSecondTurn().summarize(location);
////        System.out.println(wynikiLubelskie);
//        VoivodeshipMap mapa = new VoivodeshipMap();
//        List<String> listaLokalizacji = mapa.getNamesVoivodeships();
//        List<Vote> wyniki = new ArrayList<>();
//        for(String lokalizacja : listaLokalizacji){
//            Vote wynikiWojewodztwa = election.getSecondTurn().summarize(List.of(lokalizacja));
//            System.out.println(wynikiWojewodztwa);
//            wyniki.add(wynikiWojewodztwa);
//        }
//
//        mapa.saveToSvg("mapa.svg");
//        Samochod samochod1 = new Samochod("zielony", 2001, 22);
//        Pojazd pojazd = samochod1;
//        Pojazd pojazd3 = new Pojazd(1234);
//        samochod1.numer = "123";
//        pojazd.numer = 123;
////        pojazd.numer = 10;
////        pojazd.kolor = "kolor";
//        Samochod samochod = Samochod.getInstance("czerwony", 2000, 23);
//        Samochod samochod2 = Samochod.getInstance("czerwony", 2001, 24);
//        samochod.jedz();
//        samochod.numer = "12";
////        pojazd.numer = 13;
////        Pojazd pojazd2 = new Pojazd();
////        pojazd.numer = "123";
//        samochod.rokProdukcji = 2002;

        Samochod samochod4 = new Samochod.Builder()
                .numer2(12345)
                .build();
        System.out.println();

        List<Samochod> lista1 = new ArrayList<>();
        List<Samochod> lista2 = new LinkedList<>();
    }
}