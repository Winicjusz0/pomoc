package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ElectionTurn {

    private List<Candidate> listaKandydatow;
    private List<Vote> votes;

    public ElectionTurn(List<Candidate> listaKandydatow) {
        this.listaKandydatow = listaKandydatow;
    }

    public void populate(String sciezka) {
        votes = Vote.fromCsvLine(sciezka);
    }

    public Candidate winner(Vote vote) {
        for (Map.Entry<Candidate, Integer> x : vote.getVotesForCandidate().entrySet()) {
            if (vote.percentage(x.getKey()) > 50) {
                return x.getKey();
            }
        }
        throw new NoWinnerException("Brak zwycięzcy");
    }

    public List<Candidate> runoffCandidates(Vote vote) {
        Map.Entry<Candidate, Integer> candidate1 = null;
        Map.Entry<Candidate, Integer> candidate2 = null;
        for (Map.Entry<Candidate, Integer> x : vote.getVotesForCandidate().entrySet()) {
            if (candidate1 == null) {
                candidate1 = x;
            } else if (candidate2 == null) {
                candidate2 = x;
            } else if (x.getValue() > candidate1.getValue()) {
                if (candidate1.getValue() > candidate2.getValue()) {
                    candidate2 = candidate1;
                }
                candidate1 = x;
            } else if (x.getValue() > candidate2.getValue()) {
                if (candidate2.getValue() > candidate1.getValue()) {
                    candidate1 = candidate2;
                }
                candidate2 = x;
            }
        }
        List<Candidate> lista = new ArrayList<>();
        lista.add(candidate1.getKey());
        lista.add(candidate2.getKey());
        return lista;
    }

    public Vote summarize() {
        Vote vote = new Vote();
        return vote.summarize(this.votes, new ArrayList<>());
    }

    public Vote summarize(List<String> location) {
        List<Vote> lista = Vote.filterByLocation(this.votes, location);
        Vote vote = new Vote();
        return vote.summarize(lista, location);
    }
}