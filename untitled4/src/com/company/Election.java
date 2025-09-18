package com.company;

import com.company.Candidate;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Election {
    private List<Candidate> candidates = new ArrayList<>();
    private ElectionTurn firstTurn = new ElectionTurn(candidates);
    private ElectionTurn secondTurn = null;
    private Candidate winner;

    public List<Candidate> getCandidate(){
        List<Candidate> kopia = new ArrayList<>();

        for (Candidate candidate : candidates) {
            kopia.add(candidate);
        }

        return kopia;
    }

    public void populateCandidates(String sciezka){
        Path pathSciezka = Paths.get(sciezka);
        try(BufferedReader reader = Files.newBufferedReader(pathSciezka)){
            String linia;
            while((linia = reader.readLine()) != null){
                Candidate kandydat = new Candidate(linia);
                candidates.add(kandydat);
            }
        }
        catch(IOException e){
            System.out.println("error");
            System.out.println(e.getMessage());
        }

    }

    public void populate(String sciezka){
        populateCandidates(sciezka);
        firstTurn.populate(sciezka);
        Vote summarize = firstTurn.summarize();
        try {
            winner = firstTurn.winner(summarize);
        }
        catch(NoWinnerException e) {
            System.out.println(e.getMessage());
            List<Candidate> list = firstTurn.runoffCandidates(summarize);
            secondTurn = new ElectionTurn(list);
            secondTurn.populate("2.csv");
            Vote summarizeSecondTurn = secondTurn.summarize();
            winner = secondTurn.winner(summarizeSecondTurn);
        }
    }

    public List<Candidate> getListaKandydatow() {
        return candidates;
    }

    public ElectionTurn getFirstTurn() {
        return firstTurn;
    }

    public ElectionTurn getSecondTurn() {
        return secondTurn;
    }

    public void setListaKandydatow(List<Candidate> listaKandydatow) {
        this.candidates = listaKandydatow;
    }

    public void setFirstTurn(ElectionTurn firstTurn) {
        this.firstTurn = firstTurn;
    }

    public void setSecondTurn(ElectionTurn secondTurn) {
        this.secondTurn = secondTurn;
    }

    public Candidate getWinner() {
        return winner;
    }

    public void setWinner(Candidate winner) {
        this.winner = winner;
    }
}