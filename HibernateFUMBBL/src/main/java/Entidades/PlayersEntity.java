package Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "players", schema = "fumbbl")
public class PlayersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "team_id", nullable = false)
    private int teamId;
    @Basic
    @Column(name = "number", nullable = true)
    private Integer number;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "position", nullable = true, length = 50)
    private String position;
    @Basic
    @Column(name = "position_id", nullable = true)
    private Integer positionId;
    @Basic
    @Column(name = "injuries", nullable = true, length = 50)
    private String injuries;
    @Basic
    @Column(name = "skills", nullable = true, length = -1)
    private String skills;
    @Basic
    @Column(name = "games", nullable = true)
    private Integer games;
    @Basic
    @Column(name = "completions", nullable = true)
    private Integer completions;
    @Basic
    @Column(name = "touchdowns", nullable = true)
    private Integer touchdowns;
    @Basic
    @Column(name = "casualties", nullable = true, length = 10)
    private String casualties;
    @Basic
    @Column(name = "mvps", nullable = true)
    private Integer mvps;
    @Basic
    @Column(name = "spp", nullable = true)
    private Integer spp;

    @ManyToOne
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private TeamsEntity team;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getInjuries() {
        return injuries;
    }

    public void setInjuries(String injuries) {
        this.injuries = injuries;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getCompletions() {
        return completions;
    }

    public void setCompletions(Integer completions) {
        this.completions = completions;
    }

    public Integer getTouchdowns() {
        return touchdowns;
    }

    public void setTouchdowns(Integer touchdowns) {
        this.touchdowns = touchdowns;
    }

    public String getCasualties() {
        return casualties;
    }

    public void setCasualties(String casualties) {
        this.casualties = casualties;
    }

    public Integer getMvps() {
        return mvps;
    }

    public void setMvps(Integer mvps) {
        this.mvps = mvps;
    }

    public Integer getSpp() {
        return spp;
    }

    public void setSpp(Integer spp) {
        this.spp = spp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayersEntity that = (PlayersEntity) o;

        if (id != that.id) return false;
        if (teamId != that.teamId) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (positionId != null ? !positionId.equals(that.positionId) : that.positionId != null) return false;
        if (injuries != null ? !injuries.equals(that.injuries) : that.injuries != null) return false;
        if (skills != null ? !skills.equals(that.skills) : that.skills != null) return false;
        if (games != null ? !games.equals(that.games) : that.games != null) return false;
        if (completions != null ? !completions.equals(that.completions) : that.completions != null) return false;
        if (touchdowns != null ? !touchdowns.equals(that.touchdowns) : that.touchdowns != null) return false;
        if (casualties != null ? !casualties.equals(that.casualties) : that.casualties != null) return false;
        if (mvps != null ? !mvps.equals(that.mvps) : that.mvps != null) return false;
        if (spp != null ? !spp.equals(that.spp) : that.spp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + teamId;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (positionId != null ? positionId.hashCode() : 0);
        result = 31 * result + (injuries != null ? injuries.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + (games != null ? games.hashCode() : 0);
        result = 31 * result + (completions != null ? completions.hashCode() : 0);
        result = 31 * result + (touchdowns != null ? touchdowns.hashCode() : 0);
        result = 31 * result + (casualties != null ? casualties.hashCode() : 0);
        result = 31 * result + (mvps != null ? mvps.hashCode() : 0);
        result = 31 * result + (spp != null ? spp.hashCode() : 0);
        return result;
    }
}
