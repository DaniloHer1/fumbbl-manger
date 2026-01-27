package org.example.model.dto;

import java.util.List;

public class Team {

    private int id;
    private String name;
    private int teamValue;
    private int currentValue;
    private int treasury;
    private int fanFactor;
    private int rerolls;
    private String apothecary;
    private Coach coach;
    private Roster roster;
    private Record record;
    private List<Player> players;

    public Team() {
    }

    public Team(int id, String name, int teamValue, int currentValue, int treasury, int fanFactor, int rerolls, String apothecary, Coach coach, Roster roster, Record record, List<Player> players) {
        this.id = id;
        this.name = name;
        this.teamValue = teamValue;
        this.currentValue = currentValue;
        this.treasury = treasury;
        this.fanFactor = fanFactor;
        this.rerolls = rerolls;
        this.apothecary = apothecary;
        this.coach = coach;
        this.roster = roster;
        this.record = record;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamValue() {
        return teamValue;
    }

    public void setTeamValue(int teamValue) {
        this.teamValue = teamValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getTreasury() {
        return treasury;
    }

    public void setTreasury(int treasury) {
        this.treasury = treasury;
    }

    public int getFanFactor() {
        return fanFactor;
    }

    public void setFanFactor(int fanFactor) {
        this.fanFactor = fanFactor;
    }

    public int getRerolls() {
        return rerolls;
    }

    public void setRerolls(int rerolls) {
        this.rerolls = rerolls;
    }

    public String getApothecary() {
        return apothecary;
    }

    public void setApothecary(String apothecary) {
        this.apothecary = apothecary;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamValue=" + teamValue +
                ", currentValue=" + currentValue +
                ", treasury=" + treasury +
                ", fanFactor=" + fanFactor +
                ", rerolls=" + rerolls +
                ", apothecary='" + apothecary + '\'' +
                ", coach=" + coach +
                ", roster=" + roster +
                ", record=" + record +
                ", players=" + players +
                '}';
    }
}
