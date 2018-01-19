package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;

@Entity
@Table(name = "Clan_side", schema = "public", catalog = "pip")
@IdClass(ClanSidePK.class)
public class ClanSide {
    private String clanName;
    private int idSide;
    private Clan clanByClanName;
    private Side sideByIdSide;

    @Id
    @Column(name = "clan_name", nullable = false, length = -1)
    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    @Id
    @Column(name = "id_side", nullable = false)
    public int getIdSide() {
        return idSide;
    }

    public void setIdSide(int idSide) {
        this.idSide = idSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClanSide clanSide = (ClanSide) o;

        if (idSide != clanSide.idSide) return false;
        if (clanName != null ? !clanName.equals(clanSide.clanName) : clanSide.clanName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clanName != null ? clanName.hashCode() : 0;
        result = 31 * result + idSide;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "clan_name", referencedColumnName = "name", nullable = false)
    public Clan getClanByClanName() {
        return clanByClanName;
    }

    public void setClanByClanName(Clan clanByClanName) {
        this.clanByClanName = clanByClanName;
    }

    @ManyToOne
    @JoinColumn(name = "id_side", referencedColumnName = "id_side", nullable = false)
    public Side getSideByIdSide() {
        return sideByIdSide;
    }

    public void setSideByIdSide(Side sideByIdSide) {
        this.sideByIdSide = sideByIdSide;
    }
}
