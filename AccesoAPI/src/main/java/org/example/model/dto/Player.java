package org.example.model.dto;

import java.util.List;

public class Player {
    private int id;
    private int number;
    private String name;
    private String position;
    private int positionId;
    private String injuries;
    private List<String> skills;
    private PlayerRecord record;
    private int teamId;


    public Player() {
    }

    public Player(int id, int number, String name, String position, int positionId, String injuries, List<String> skills, PlayerRecord record) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.position = position;
        this.positionId = positionId;
        this.injuries = injuries;
        this.skills = skills;
        this.record = record;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getInjuries() {
        return injuries;
    }

    public void setInjuries(String injuries) {
        this.injuries = injuries;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public PlayerRecord getRecord() {
        return record;
    }

    public void setRecord(PlayerRecord record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", positionId=" + positionId +
                ", injuries='" + injuries + '\'' +
                ", skills=" + skills +
                ", record=" + record +
                '}';
    }
}
