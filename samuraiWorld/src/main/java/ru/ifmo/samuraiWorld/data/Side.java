package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Side {
    private int idSide;
    private int idWar;
    private boolean status;
    private Collection<Battle> battlesByIdSide;
    private Collection<ClanSide> clanSidesByIdSide;
    private War warByIdWar;
    private Collection<SideBattle> sideBattlesByIdSide;

    @Id
    @Column(name = "id_side", nullable = false)
    public int getIdSide() {
        return idSide;
    }

    public void setIdSide(int idSide) {
        this.idSide = idSide;
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
    @Column(name = "status", nullable = false)
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Side side = (Side) o;

        if (idSide != side.idSide) return false;
        if (idWar != side.idWar) return false;
        if (status != side.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSide;
        result = 31 * result + idWar;
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "sideByVictorySide")
    public Collection<Battle> getBattlesByIdSide() {
        return battlesByIdSide;
    }

    public void setBattlesByIdSide(Collection<Battle> battlesByIdSide) {
        this.battlesByIdSide = battlesByIdSide;
    }

    @OneToMany(mappedBy = "sideByIdSide")
    public Collection<ClanSide> getClanSidesByIdSide() {
        return clanSidesByIdSide;
    }

    public void setClanSidesByIdSide(Collection<ClanSide> clanSidesByIdSide) {
        this.clanSidesByIdSide = clanSidesByIdSide;
    }

    @ManyToOne
    @JoinColumn(name = "id_war", referencedColumnName = "id", nullable = false)
    public War getWarByIdWar() {
        return warByIdWar;
    }

    public void setWarByIdWar(War warByIdWar) {
        this.warByIdWar = warByIdWar;
    }

    @OneToMany(mappedBy = "sideByIdSide")
    public Collection<SideBattle> getSideBattlesByIdSide() {
        return sideBattlesByIdSide;
    }

    public void setSideBattlesByIdSide(Collection<SideBattle> sideBattlesByIdSide) {
        this.sideBattlesByIdSide = sideBattlesByIdSide;
    }
}
