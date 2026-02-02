package Entidades;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "teams", schema = "fumbbl")
public class TeamsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Basic
    @Column(name = "coach_id", nullable = true)
    private Integer coachId;
    @Basic
    @Column(name = "coach_name", nullable = true, length = 100)
    private String coachName;
    @Basic
    @Column(name = "roster_id", nullable = true)
    private Integer rosterId;
    @Basic
    @Column(name = "roster_name", nullable = true, length = 100)
    private String rosterName;
    @Basic
    @Column(name = "team_value", nullable = true)
    private Integer teamValue;
    @Basic
    @Column(name = "current_team_value", nullable = true)
    private Integer currentTeamValue;
    @Basic
    @Column(name = "treasury", nullable = true)
    private Integer treasury;
    @Basic
    @Column(name = "fan_factor", nullable = true)
    private Integer fanFactor;
    @Basic
    @Column(name = "rerolls", nullable = true)
    private Integer rerolls;
    @Basic
    @Column(name = "apothecary", nullable = true, length = 10)
    private String apothecary;
    @Basic
    @Column(name = "games", nullable = true)
    private Integer games;
    @Basic
    @Column(name = "wins", nullable = true)
    private Integer wins;
    @Basic
    @Column(name = "ties", nullable = true)
    private Integer ties;
    @Basic
    @Column(name = "losses", nullable = true)
    private Integer losses;

    @OneToMany(mappedBy = "team")
    private List<PlayersEntity> players;

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

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getRosterId() {
        return rosterId;
    }

    public void setRosterId(Integer rosterId) {
        this.rosterId = rosterId;
    }

    public String getRosterName() {
        return rosterName;
    }

    public void setRosterName(String rosterName) {
        this.rosterName = rosterName;
    }

    public Integer getTeamValue() {
        return teamValue;
    }

    public void setTeamValue(Integer teamValue) {
        this.teamValue = teamValue;
    }

    public Integer getCurrentTeamValue() {
        return currentTeamValue;
    }

    public void setCurrentTeamValue(Integer currentTeamValue) {
        this.currentTeamValue = currentTeamValue;
    }

    public Integer getTreasury() {
        return treasury;
    }

    public void setTreasury(Integer treasury) {
        this.treasury = treasury;
    }

    public Integer getFanFactor() {
        return fanFactor;
    }

    public void setFanFactor(Integer fanFactor) {
        this.fanFactor = fanFactor;
    }

    public Integer getRerolls() {
        return rerolls;
    }

    public void setRerolls(Integer rerolls) {
        this.rerolls = rerolls;
    }

    public String getApothecary() {
        return apothecary;
    }

    public void setApothecary(String apothecary) {
        this.apothecary = apothecary;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getTies() {
        return ties;
    }

    public void setTies(Integer ties) {
        this.ties = ties;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamsEntity that = (TeamsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (coachId != null ? !coachId.equals(that.coachId) : that.coachId != null) return false;
        if (coachName != null ? !coachName.equals(that.coachName) : that.coachName != null) return false;
        if (rosterId != null ? !rosterId.equals(that.rosterId) : that.rosterId != null) return false;
        if (rosterName != null ? !rosterName.equals(that.rosterName) : that.rosterName != null) return false;
        if (teamValue != null ? !teamValue.equals(that.teamValue) : that.teamValue != null) return false;
        if (currentTeamValue != null ? !currentTeamValue.equals(that.currentTeamValue) : that.currentTeamValue != null)
            return false;
        if (treasury != null ? !treasury.equals(that.treasury) : that.treasury != null) return false;
        if (fanFactor != null ? !fanFactor.equals(that.fanFactor) : that.fanFactor != null) return false;
        if (rerolls != null ? !rerolls.equals(that.rerolls) : that.rerolls != null) return false;
        if (apothecary != null ? !apothecary.equals(that.apothecary) : that.apothecary != null) return false;
        if (games != null ? !games.equals(that.games) : that.games != null) return false;
        if (wins != null ? !wins.equals(that.wins) : that.wins != null) return false;
        if (ties != null ? !ties.equals(that.ties) : that.ties != null) return false;
        if (losses != null ? !losses.equals(that.losses) : that.losses != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (coachId != null ? coachId.hashCode() : 0);
        result = 31 * result + (coachName != null ? coachName.hashCode() : 0);
        result = 31 * result + (rosterId != null ? rosterId.hashCode() : 0);
        result = 31 * result + (rosterName != null ? rosterName.hashCode() : 0);
        result = 31 * result + (teamValue != null ? teamValue.hashCode() : 0);
        result = 31 * result + (currentTeamValue != null ? currentTeamValue.hashCode() : 0);
        result = 31 * result + (treasury != null ? treasury.hashCode() : 0);
        result = 31 * result + (fanFactor != null ? fanFactor.hashCode() : 0);
        result = 31 * result + (rerolls != null ? rerolls.hashCode() : 0);
        result = 31 * result + (apothecary != null ? apothecary.hashCode() : 0);
        result = 31 * result + (games != null ? games.hashCode() : 0);
        result = 31 * result + (wins != null ? wins.hashCode() : 0);
        result = 31 * result + (ties != null ? ties.hashCode() : 0);
        result = 31 * result + (losses != null ? losses.hashCode() : 0);
        return result;
    }
}
