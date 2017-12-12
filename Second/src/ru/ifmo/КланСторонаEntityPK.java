package ru.ifmo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class КланСторонаEntityPK implements Serializable {
    private String названиеКлана;
    private int idСтороны;

    @Column(name = "Название_клана", nullable = false, length = -1)
    @Id
    public String getНазваниеКлана() {
        return названиеКлана;
    }

    public void setНазваниеКлана(String названиеКлана) {
        this.названиеКлана = названиеКлана;
    }

    @Column(name = "id_стороны", nullable = false)
    @Id
    public int getIdСтороны() {
        return idСтороны;
    }

    public void setIdСтороны(int idСтороны) {
        this.idСтороны = idСтороны;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        КланСторонаEntityPK that = (КланСторонаEntityPK) o;

        if (idСтороны != that.idСтороны) return false;
        if (названиеКлана != null ? !названиеКлана.equals(that.названиеКлана) : that.названиеКлана != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = названиеКлана != null ? названиеКлана.hashCode() : 0;
        result = 31 * result + idСтороны;
        return result;
    }
}
