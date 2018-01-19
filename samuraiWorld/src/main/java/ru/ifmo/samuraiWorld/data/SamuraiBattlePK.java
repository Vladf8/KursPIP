package ru.ifmo.samuraiWorld.data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SamuraiBattlePK implements Serializable {
    private int idSamurai;
    private int idBattle;

    @Column(name = "id_samurai", nullable = false)
    @Id
    public int getIdSamurai() {
        return idSamurai;
    }

    public void setIdSamurai(int idSamurai) {
        this.idSamurai = idSamurai;
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

        SamuraiBattlePK that = (SamuraiBattlePK) o;

        if (idSamurai != that.idSamurai) return false;
        if (idBattle != that.idBattle) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSamurai;
        result = 31 * result + idBattle;
        return result;
    }
}
