package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Battle {
    private int id;
    private int idWar;
    private Integer victorySide;
    private Date date;
    private War warById;
    private Side sideByVictorySide;
    private Collection<SamuraiBattle> samuraiBattlesById;
    private Collection<SideBattle> sideBattlesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_war", nullable = false)
    public int getIdWar() {
        return idWar;
    }

    public void setIdWar(int idWar) {
        this.idWar = idWar;
    }

    @Basic
    @Column(name = "victory_side", nullable = true)
    public Integer getVictorySide() {
        return victorySide;
    }

    public void setVictorySide(Integer victorySide) {
        this.victorySide = victorySide;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Battle battle = (Battle) o;

        if (id != battle.id) return false;
        if (idWar != battle.idWar) return false;
        if (victorySide != null ? !victorySide.equals(battle.victorySide) : battle.victorySide != null) return false;
        if (date != null ? !date.equals(battle.date) : battle.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idWar;
        result = 31 * result + (victorySide != null ? victorySide.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public War getWarById() {
        return warById;
    }

    public void setWarById(War warById) {
        this.warById = warById;
    }

    @ManyToOne
    @JoinColumn(name = "victory_side", referencedColumnName = "id_side")
    public Side getSideByVictorySide() {
        return sideByVictorySide;
    }

    public void setSideByVictorySide(Side sideByVictorySide) {
        this.sideByVictorySide = sideByVictorySide;
    }

    @OneToMany(mappedBy = "battleByIdBattle")
    public Collection<SamuraiBattle> getSamuraiBattlesById() {
        return samuraiBattlesById;
    }

    public void setSamuraiBattlesById(Collection<SamuraiBattle> samuraiBattlesById) {
        this.samuraiBattlesById = samuraiBattlesById;
    }

    @OneToMany(mappedBy = "battleByIdBattle")
    public Collection<SideBattle> getSideBattlesById() {
        return sideBattlesById;
    }

    public void setSideBattlesById(Collection<SideBattle> sideBattlesById) {
        this.sideBattlesById = sideBattlesById;
    }
}
