package ru.ifmo.samuraiWorld.data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DuelPK implements Serializable {
    private int firstSamurai;
    private int secondSamurai;

    @Column(name = "first_samurai", nullable = false)
    @Id
    public int getFirstSamurai() {
        return firstSamurai;
    }

    public void setFirstSamurai(int firstSamurai) {
        this.firstSamurai = firstSamurai;
    }

    @Column(name = "second_samurai", nullable = false)
    @Id
    public int getSecondSamurai() {
        return secondSamurai;
    }

    public void setSecondSamurai(int secondSamurai) {
        this.secondSamurai = secondSamurai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DuelPK duelPK = (DuelPK) o;

        if (firstSamurai != duelPK.firstSamurai) return false;
        if (secondSamurai != duelPK.secondSamurai) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstSamurai;
        result = 31 * result + secondSamurai;
        return result;
    }
}
