package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;

@Entity
@IdClass(DuelPK.class)
public class Duel {
    private int firstSamurai;
    private int secondSamurai;
    private Integer idWinning;
    private Samurai samuraiByFirstSamurai;
    private Samurai samuraiBySecondSamurai;

    @Id
    @Column(name = "first_samurai", nullable = false)
    public int getFirstSamurai() {
        return firstSamurai;
    }

    public void setFirstSamurai(int firstSamurai) {
        this.firstSamurai = firstSamurai;
    }

    @Id
    @Column(name = "second_samurai", nullable = false)
    public int getSecondSamurai() {
        return secondSamurai;
    }

    public void setSecondSamurai(int secondSamurai) {
        this.secondSamurai = secondSamurai;
    }

    @Basic
    @Column(name = "id_winning", nullable = true)
    public Integer getIdWinning() {
        return idWinning;
    }

    public void setIdWinning(Integer idWinning) {
        this.idWinning = idWinning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Duel duel = (Duel) o;

        if (firstSamurai != duel.firstSamurai) return false;
        if (secondSamurai != duel.secondSamurai) return false;
        if (idWinning != null ? !idWinning.equals(duel.idWinning) : duel.idWinning != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstSamurai;
        result = 31 * result + secondSamurai;
        result = 31 * result + (idWinning != null ? idWinning.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "first_samurai", referencedColumnName = "id", nullable = false)
    public Samurai getSamuraiByFirstSamurai() {
        return samuraiByFirstSamurai;
    }

    public void setSamuraiByFirstSamurai(Samurai samuraiByFirstSamurai) {
        this.samuraiByFirstSamurai = samuraiByFirstSamurai;
    }

    @ManyToOne
    @JoinColumn(name = "second_samurai", referencedColumnName = "id", nullable = false)
    public Samurai getSamuraiBySecondSamurai() {
        return samuraiBySecondSamurai;
    }

    public void setSamuraiBySecondSamurai(Samurai samuraiBySecondSamurai) {
        this.samuraiBySecondSamurai = samuraiBySecondSamurai;
    }
}
