package org.example.model.dto;

public class Record {
    private int games;
    private int wins;
    private int ties;
    private int losses;

    public Record() {
    }

    public Record(int games, int wins, int ties, int losses) {
        this.games = games;
        this.wins = wins;
        this.ties = ties;
        this.losses = losses;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    @Override
    public String toString() {
        return "Record{" +
                "games=" + games +
                ", wins=" + wins +
                ", ties=" + ties +
                ", losses=" + losses +
                '}';
    }
}
