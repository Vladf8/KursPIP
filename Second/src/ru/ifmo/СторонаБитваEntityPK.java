package ru.ifmo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class СторонаБитваEntityPK implements Serializable {
    private int idСтороны;
    private int idБитва;

    @Column(name = "id_стороны", nullable = false)
    @Id
    public int getIdСтороны() {
        return idСтороны;
    }

    public void setIdСтороны(int idСтороны) {
        this.idСтороны = idСтороны;
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

        СторонаБитваEntityPK that = (СторонаБитваEntityPK) o;

        if (idСтороны != that.idСтороны) return false;
        if (idБитва != that.idБитва) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idСтороны;
        result = 31 * result + idБитва;
        return result;
    }
}
