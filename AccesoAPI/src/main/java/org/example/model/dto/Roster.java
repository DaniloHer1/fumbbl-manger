package org.example.model.dto;

public class Roster {
    private int id;
    private String name;
    public Roster() {

    }
    public Roster(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Roster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
