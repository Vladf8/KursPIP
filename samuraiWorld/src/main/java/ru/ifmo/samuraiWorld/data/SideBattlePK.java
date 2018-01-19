package ru.ifmo.samuraiWorld.data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SideBattlePK implements Serializable {
    private int idSide;
    private int idBattle;

    @Column(name = "id_side", nullable = false)
    @Id
    public int getIdSide() {
        return idSide;
    }

    public void setIdSide(int idSide) {
        this.idSide = idSide;
    }

    @Column(name = "id_battle", nullable = false)
    @Id
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

        SideBattlePK that = (SideBattlePK) o;

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
}
