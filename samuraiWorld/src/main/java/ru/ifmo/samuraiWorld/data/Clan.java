package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Clan {
    private String name;
    private String genericSign;
    private int idLeader;
    private Samurai samuraiByIdLeader;
    private Collection<ClanSide> clanSidesByName;
    private Collection<Land> landsByName;
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
    @Column(name = "generic_sign", nullable = false, length = -1)
    public String getGenericSign() {
        return genericSign;
    }

    public void setGenericSign(String genericSign) {
        this.genericSign = genericSign;
    }

    @Basic
    @Column(name = "id_leader", nullable = false)
    public int getIdLeader() {
        return idLeader;
    }

    public void setIdLeader(int idLeader) {
        this.idLeader = idLeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clan clan = (Clan) o;

        if (idLeader != clan.idLeader) return false;
        if (name != null ? !name.equals(clan.name) : clan.name != null) return false;
        if (genericSign != null ? !genericSign.equals(clan.genericSign) : clan.genericSign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (genericSign != null ? genericSign.hashCode() : 0);
        result = 31 * result + idLeader;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_leader", referencedColumnName = "id", nullable = false)
    public Samurai getSamuraiByIdLeader() {
        return samuraiByIdLeader;
    }

    public void setSamuraiByIdLeader(Samurai samuraiByIdLeader) {
        this.samuraiByIdLeader = samuraiByIdLeader;
    }

    @OneToMany(mappedBy = "clanByClanName")
    public Collection<ClanSide> getClanSidesByName() {
        return clanSidesByName;
    }

    public void setClanSidesByName(Collection<ClanSide> clanSidesByName) {
        this.clanSidesByName = clanSidesByName;
    }

    @OneToMany(mappedBy = "clanByNameClan")
    public Collection<Land> getLandsByName() {
        return landsByName;
    }

    public void setLandsByName(Collection<Land> landsByName) {
        this.landsByName = landsByName;
    }

    @OneToMany(mappedBy = "clanByClanName")
    public Collection<Samurai> getSamuraisByName() {
        return samuraisByName;
    }

    public void setSamuraisByName(Collection<Samurai> samuraisByName) {
        this.samuraisByName = samuraisByName;
    }
}
