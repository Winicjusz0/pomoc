package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vote {
    private Map<Candidate, Integer> votesForCandidate = new HashMap<>();
    private List<String> location = new ArrayList<>();
    private float sumaWszystkichGlosow;

    public static List<Vote> fromCsvLine(String sciezka){
        List<Vote> votes = new ArrayList<>();
        Path pathSciezka = Paths.get(sciezka);
        try(BufferedReader reader = Files.newBufferedReader(pathSciezka)){
            reader.readLine();
            String linia;
            Election election = new Election();
            election.populateCandidates("kandydaci.txt");
            while((linia = reader.readLine()) != null){
                String[] dane = linia.split(",");
                Vote vote = new Vote();
                vote.location.add(dane[2]);
                vote.location.add(dane[1]);
                vote.location.add(dane[0]);
                List<Candidate> candidate = election.getCandidate();
                vote.votesForCandidate.put(candidate.get(0), Integer.valueOf(dane[3]));
                vote.votesForCandidate.put(candidate.get(1), Integer.valueOf(dane[4]));
                if (dane.length > 5) {
                    vote.votesForCandidate.put(candidate.get(2), Integer.valueOf(dane[5]));
                    vote.votesForCandidate.put(candidate.get(3), Integer.valueOf(dane[6]));
                    vote.votesForCandidate.put(candidate.get(4), Integer.valueOf(dane[7]));
                    vote.votesForCandidate.put(candidate.get(5), Integer.valueOf(dane[8]));
                    vote.votesForCandidate.put(candidate.get(6), Integer.valueOf(dane[9]));
                    vote.votesForCandidate.put(candidate.get(7), Integer.valueOf(dane[10]));
                    vote.votesForCandidate.put(candidate.get(8), Integer.valueOf(dane[11]));
                    vote.votesForCandidate.put(candidate.get(9), Integer.valueOf(dane[12]));
                    vote.votesForCandidate.put(candidate.get(10), Integer.valueOf(dane[13]));
                }
                votes.add(vote);
            }
        }
        catch(IOException e){
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        return votes;
    }
    
    public Vote summarize(List<Vote> lista, List<String> locationList){
        Vote vote = new Vote();
        vote.location = locationList;
        for (Vote vote1 : lista) {
            for(Map.Entry<Candidate, Integer> x : vote1.votesForCandidate.entrySet()){
                if (vote.votesForCandidate.get(x.getKey()) != null) {
                    int suma = vote.votesForCandidate.get(x.getKey());
                    vote.votesForCandidate.put(x.getKey(), suma + x.getValue());
                }
                else{
                    vote.votesForCandidate.put(x.getKey(), x.getValue());
                }
            }
        }
        return vote;
    }

    public static List<Vote> filterByLocation(List<Vote> voteList, List<String> locationList){
        List<Vote> locationVotes = new ArrayList<>();
        for (Vote vote : voteList){
            if (locationList.size() == 1){
                if (vote.location.get(0).equals(locationList.get(0))){
                    locationVotes.add(vote);
                }
            }
            else if (locationList.size() == 2){
                if (vote.location.get(0).equals(locationList.get(0)) && vote.location.get(1).equals(locationList.get(1))){
                    locationVotes.add(vote);
                }
            }
            else if (locationList.size() == 3){
                if (vote.location.get(0).equals(locationList.get(0)) && vote.location.get(1).equals(locationList.get(1)) && vote.location.get(2).equals(locationList.get(2))){
                    locationVotes.add(vote);
                }
            }
        }
        return locationVotes;
    }

    public int votes(Candidate kandydat){
        return votesForCandidate.get(kandydat);
    }

    public float percentage(Candidate kandydat){
        float suma = votesForCandidate.get(kandydat);
        return (suma * 100) / sumaWszystkichGlosow;
    }

    private void sumaWszystkichGlosow(){
        this.sumaWszystkichGlosow = 0;
        for(Map.Entry<Candidate, Integer> x : votesForCandidate.entrySet()){
            sumaWszystkichGlosow += x.getValue(); // x.getValue() == votesForCandidate.get(x.getKey())
        }
    }

    @Override
    public String toString() {
        sumaWszystkichGlosow();
        String napis = "";
        for(Map.Entry<Candidate, Integer> x : votesForCandidate.entrySet()){
            napis += x.getKey().nazwaKandydata();
            napis += " ";
            napis += percentage(x.getKey());
            napis += "\n";
        }
        return napis;
    }

    public Map<Candidate, Integer> getVotesForCandidate() {
        return votesForCandidate;
    }

    public List<String> getLocation() {
        return location;
    }
}
