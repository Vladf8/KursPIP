package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Training {
    private int id;
    private String dodzeName;
    private Date time;
    private Collection<SamuraiTraining> samuraiTrainingsById;
    private Dodze dodzeByDodzeName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dodze_name", nullable = true, length = -1)
    public String getDodzeName() {
        return dodzeName;
    }

    public void setDodzeName(String dodzeName) {
        this.dodzeName = dodzeName;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Training training = (Training) o;

        if (id != training.id) return false;
        if (dodzeName != null ? !dodzeName.equals(training.dodzeName) : training.dodzeName != null) return false;
        if (time != null ? !time.equals(training.time) : training.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dodzeName != null ? dodzeName.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "trainingByIdTraining")
    public Collection<SamuraiTraining> getSamuraiTrainingsById() {
        return samuraiTrainingsById;
    }

    public void setSamuraiTrainingsById(Collection<SamuraiTraining> samuraiTrainingsById) {
        this.samuraiTrainingsById = samuraiTrainingsById;
    }

    @ManyToOne
    @JoinColumn(name = "dodze_name", referencedColumnName = "name")
    public Dodze getDodzeByDodzeName() {
        return dodzeByDodzeName;
    }

    public void setDodzeByDodzeName(Dodze dodzeByDodzeName) {
        this.dodzeByDodzeName = dodzeByDodzeName;
    }
}
