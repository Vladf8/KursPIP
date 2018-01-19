package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;

@Entity
@Table(name = "Samurai_battle", schema = "public", catalog = "pip")
@IdClass(SamuraiBattlePK.class)
public class SamuraiBattle {
    private int idSamurai;
    private int idBattle;
    private Samurai samuraiByIdSamurai;
    private Battle battleByIdBattle;

    @Id
    @Column(name = "id_samurai", nullable = false)
    public int getIdSamurai() {
        return idSamurai;
    }

    public void setIdSamurai(int idSamurai) {
        this.idSamurai = idSamurai;
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

        SamuraiBattle that = (SamuraiBattle) o;

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

    @ManyToOne
    @JoinColumn(name = "id_samurai", referencedColumnName = "id", nullable = false)
    public Samurai getSamuraiByIdSamurai() {
        return samuraiByIdSamurai;
    }

    public void setSamuraiByIdSamurai(Samurai samuraiByIdSamurai) {
        this.samuraiByIdSamurai = samuraiByIdSamurai;
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
