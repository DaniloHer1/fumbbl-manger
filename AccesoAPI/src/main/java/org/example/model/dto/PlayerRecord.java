package org.example.model.dto;

public class PlayerRecord {
    private int games;
    private int completions;
    private int touchdowns;
    private int casualities;
    private int mvps;
    private int ssp;

    public PlayerRecord() {
    }

    public PlayerRecord(int games, int completions, int touchdowns, int casualities, int mvps, int ssp) {
        this.games = games;
        this.completions = completions;
        this.touchdowns = touchdowns;
        this.casualities = casualities;
        this.mvps = mvps;
        this.ssp = ssp;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getCompletions() {
        return completions;
    }

    public void setCompletions(int completions) {
        this.completions = completions;
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    public void setTouchdowns(int touchdowns) {
        this.touchdowns = touchdowns;
    }

    public int getCasualities() {
        return casualities;
    }

    public void setCasualities(int casualities) {
        this.casualities = casualities;
    }

    public int getMvps() {
        return mvps;
    }

    public void setMvps(int mvps) {
        this.mvps = mvps;
    }

    public int getSsp() {
        return ssp;
    }

    public void setSsp(int ssp) {
        this.ssp = ssp;
    }

    @Override
    public String toString() {
        return "PlayerRecord{" +
                "games=" + games +
                ", completions=" + completions +
                ", touchdowns=" + touchdowns +
                ", casualities=" + casualities +
                ", mvps=" + mvps +
                ", ssp=" + ssp +
                '}';
    }
}
