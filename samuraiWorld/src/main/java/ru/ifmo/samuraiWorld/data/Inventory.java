package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;

@Entity
public class Inventory {
    private int id;
    private int idOwner;
    private String name;
    private Samurai samuraiByIdOwner;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_owner", nullable = false)
    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        if (id != inventory.id) return false;
        if (idOwner != inventory.idOwner) return false;
        if (name != null ? !name.equals(inventory.name) : inventory.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idOwner;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_owner", referencedColumnName = "id", nullable = false)
    public Samurai getSamuraiByIdOwner() {
        return samuraiByIdOwner;
    }

    public void setSamuraiByIdOwner(Samurai samuraiByIdOwner) {
        this.samuraiByIdOwner = samuraiByIdOwner;
    }
}
