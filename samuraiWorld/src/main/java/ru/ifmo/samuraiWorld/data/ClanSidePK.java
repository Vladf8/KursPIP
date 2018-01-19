package ru.ifmo.samuraiWorld.data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ClanSidePK implements Serializable {
    private String clanName;
    private int idSide;

    @Column(name = "clan_name", nullable = false, length = -1)
    @Id
    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    @Column(name = "id_side", nullable = false)
    @Id
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

        ClanSidePK that = (ClanSidePK) o;

        if (idSide != that.idSide) return false;
        if (clanName != null ? !clanName.equals(that.clanName) : that.clanName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clanName != null ? clanName.hashCode() : 0;
        result = 31 * result + idSide;
        return result;
    }
}
