package ru.ifmo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class СамурайБитваEntityPK implements Serializable {
    private int idСамурай;
    private int idБитва;

    @Column(name = "id_самурай", nullable = false)
    @Id
    public int getIdСамурай() {
        return idСамурай;
    }

    public void setIdСамурай(int idСамурай) {
        this.idСамурай = idСамурай;
    }

    @Column(name = "id_битва", nullable = false)
    @Id
    public int getIdБитва() {
        return idБитва;
    }

    public void setIdБитва(int idБитва) {
        this.idБитва = idБитва;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        СамурайБитваEntityPK that = (СамурайБитваEntityPK) o;

        if (idСамурай != that.idСамурай) return false;
        if (idБитва != that.idБитва) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idСамурай;
        result = 31 * result + idБитва;
        return result;
    }
}
