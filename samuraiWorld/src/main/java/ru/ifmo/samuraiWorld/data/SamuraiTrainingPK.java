package ru.ifmo.samuraiWorld.data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SamuraiTrainingPK implements Serializable {
    private int idSamurai;
    private int idTraining;

    @Column(name = "id_samurai", nullable = false)
    @Id
    public int getIdSamurai() {
        return idSamurai;
    }

    public void setIdSamurai(int idSamurai) {
        this.idSamurai = idSamurai;
    }

    @Column(name = "id_training", nullable = false)
    @Id
    public int getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(int idTraining) {
        this.idTraining = idTraining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SamuraiTrainingPK that = (SamuraiTrainingPK) o;

        if (idSamurai != that.idSamurai) return false;
        if (idTraining != that.idTraining) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSamurai;
        result = 31 * result + idTraining;
        return result;
    }
}
