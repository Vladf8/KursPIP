package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Samurai {
    private int id;
    private String name;
    private Short age;
    private Short weight;
    private Short height;
    private Boolean alive;
    private String landName;
    private String clanName;
    private Collection<Clan> clansById;
    private Collection<Duel> duelsById;
    private Collection<Duel> duelsById_0;
    private Collection<Inventory> inventoriesById;
    private Land landByLandName;
    private Clan clanByClanName;
    private Collection<SamuraiBattle> samuraiBattlesById;
    private Collection<SamuraiTraining> samuraiTrainingsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @Basic
    @Column(name = "weight", nullable = true)
    public Short getWeight() {
        return weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "height", nullable = true)
    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    @Basic
    @Column(name = "alive", nullable = true)
    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    @Basic
    @Column(name = "land_name", nullable = false, length = -1)
    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    @Basic
    @Column(name = "clan_name", nullable = false, length = -1)
    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Samurai samurai = (Samurai) o;

        if (id != samurai.id) return false;
        if (name != null ? !name.equals(samurai.name) : samurai.name != null) return false;
        if (age != null ? !age.equals(samurai.age) : samurai.age != null) return false;
        if (weight != null ? !weight.equals(samurai.weight) : samurai.weight != null) return false;
        if (height != null ? !height.equals(samurai.height) : samurai.height != null) return false;
        if (alive != null ? !alive.equals(samurai.alive) : samurai.alive != null) return false;
        if (landName != null ? !landName.equals(samurai.landName) : samurai.landName != null) return false;
        if (clanName != null ? !clanName.equals(samurai.clanName) : samurai.clanName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (alive != null ? alive.hashCode() : 0);
        result = 31 * result + (landName != null ? landName.hashCode() : 0);
        result = 31 * result + (clanName != null ? clanName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "samuraiByIdLeader")
    public Collection<Clan> getClansById() {
        return clansById;
    }

    public void setClansById(Collection<Clan> clansById) {
        this.clansById = clansById;
    }

    @OneToMany(mappedBy = "samuraiByFirstSamurai")
    public Collection<Duel> getDuelsById() {
        return duelsById;
    }

    public void setDuelsById(Collection<Duel> duelsById) {
        this.duelsById = duelsById;
    }

    @OneToMany(mappedBy = "samuraiBySecondSamurai")
    public Collection<Duel> getDuelsById_0() {
        return duelsById_0;
    }

    public void setDuelsById_0(Collection<Duel> duelsById_0) {
        this.duelsById_0 = duelsById_0;
    }

    @OneToMany(mappedBy = "samuraiByIdOwner")
    public Collection<Inventory> getInventoriesById() {
        return inventoriesById;
    }

    public void setInventoriesById(Collection<Inventory> inventoriesById) {
        this.inventoriesById = inventoriesById;
    }

    @ManyToOne
    @JoinColumn(name = "land_name", referencedColumnName = "name", nullable = false)
    public Land getLandByLandName() {
        return landByLandName;
    }

    public void setLandByLandName(Land landByLandName) {
        this.landByLandName = landByLandName;
    }

    @ManyToOne
    @JoinColumn(name = "clan_name", referencedColumnName = "name", nullable = false)
    public Clan getClanByClanName() {
        return clanByClanName;
    }

    public void setClanByClanName(Clan clanByClanName) {
        this.clanByClanName = clanByClanName;
    }

    @OneToMany(mappedBy = "samuraiByIdSamurai")
    public Collection<SamuraiBattle> getSamuraiBattlesById() {
        return samuraiBattlesById;
    }

    public void setSamuraiBattlesById(Collection<SamuraiBattle> samuraiBattlesById) {
        this.samuraiBattlesById = samuraiBattlesById;
    }

    @OneToMany(mappedBy = "samuraiByIdSamurai")
    public Collection<SamuraiTraining> getSamuraiTrainingsById() {
        return samuraiTrainingsById;
    }

    public void setSamuraiTrainingsById(Collection<SamuraiTraining> samuraiTrainingsById) {
        this.samuraiTrainingsById = samuraiTrainingsById;
    }
    public Samurai(String name, Short age){
        this.name = name;
        this.age = age;
    }
}
