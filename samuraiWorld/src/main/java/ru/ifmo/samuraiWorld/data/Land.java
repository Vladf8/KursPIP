package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Land {
    private String name;
    private String nameClan;
    private Clan clanByNameClan;
    private Collection<Samurai> samuraisByName;

    @Id
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "name_clan", nullable = true, length = -1)
    public String getNameClan() {
        return nameClan;
    }

    public void setNameClan(String nameClan) {
        this.nameClan = nameClan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Land land = (Land) o;

        if (name != null ? !name.equals(land.name) : land.name != null) return false;
        if (nameClan != null ? !nameClan.equals(land.nameClan) : land.nameClan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (nameClan != null ? nameClan.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "name_clan", referencedColumnName = "name")
    public Clan getClanByNameClan() {
        return clanByNameClan;
    }

    public void setClanByNameClan(Clan clanByNameClan) {
        this.clanByNameClan = clanByNameClan;
    }

    @OneToMany(mappedBy = "landByLandName")
    public Collection<Samurai> getSamuraisByName() {
        return samuraisByName;
    }

    public void setSamuraisByName(Collection<Samurai> samuraisByName) {
        this.samuraisByName = samuraisByName;
    }
}
