package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;

@Entity
@Table(name = "Samurai_training", schema = "public", catalog = "pip")
@IdClass(SamuraiTrainingPK.class)
public class SamuraiTraining {
    private int idSamurai;
    private int idTraining;
    private Samurai samuraiByIdSamurai;
    private Training trainingByIdTraining;

    @Id
    @Column(name = "id_samurai", nullable = false)
    public int getIdSamurai() {
        return idSamurai;
    }

    public void setIdSamurai(int idSamurai) {
        this.idSamurai = idSamurai;
    }

    @Id
    @Column(name = "id_training", nullable = false)
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

        SamuraiTraining that = (SamuraiTraining) o;

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

    @ManyToOne
    @JoinColumn(name = "id_samurai", referencedColumnName = "id", nullable = false)
    public Samurai getSamuraiByIdSamurai() {
        return samuraiByIdSamurai;
    }

    public void setSamuraiByIdSamurai(Samurai samuraiByIdSamurai) {
        this.samuraiByIdSamurai = samuraiByIdSamurai;
    }

    @ManyToOne
    @JoinColumn(name = "id_training", referencedColumnName = "id", nullable = false)
    public Training getTrainingByIdTraining() {
        return trainingByIdTraining;
    }

    public void setTrainingByIdTraining(Training trainingByIdTraining) {
        this.trainingByIdTraining = trainingByIdTraining;
    }
}
