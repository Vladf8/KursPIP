package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;

@Entity
@Table(name = "Side_battle", schema = "public", catalog = "pip")
@IdClass(SideBattlePK.class)
public class SideBattle {
    private int idSide;
    private int idBattle;
    private Side sideByIdSide;
    private Battle battleByIdBattle;

    @Id
    @Column(name = "id_side", nullable = false)
    public int getIdSide() {
        return idSide;
    }

    public void setIdSide(int idSide) {
        this.idSide = idSide;
    }

    @Id
    @Column(name = "id_battle", nullable = false)
    public int getIdBattle() {
        return idBattle;
    }

    public void setIdBattle(int idBattle) {
        this.idBattle = idBattle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SideBattle that = (SideBattle) o;

        if (idSide != that.idSide) return false;
        if (idBattle != that.idBattle) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSide;
        result = 31 * result + idBattle;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_side", referencedColumnName = "id_side", nullable = false)
    public Side getSideByIdSide() {
        return sideByIdSide;
    }

    public void setSideByIdSide(Side sideByIdSide) {
        this.sideByIdSide = sideByIdSide;
    }

    @ManyToOne
    @JoinColumn(name = "id_battle", referencedColumnName = "id", nullable = false)
    public Battle getBattleByIdBattle() {
        return battleByIdBattle;
    }

    public void setBattleByIdBattle(Battle battleByIdBattle) {
        this.battleByIdBattle = battleByIdBattle;
    }
}
