package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Dodze {
    private String name;
    private String description;
    private Collection<Training> trainingsByName;

    @Id
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dodze dodze = (Dodze) o;

        if (name != null ? !name.equals(dodze.name) : dodze.name != null) return false;
        if (description != null ? !description.equals(dodze.description) : dodze.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dodzeByDodzeName")
    public Collection<Training> getTrainingsByName() {
        return trainingsByName;
    }

    public void setTrainingsByName(Collection<Training> trainingsByName) {
        this.trainingsByName = trainingsByName;
    }
}
