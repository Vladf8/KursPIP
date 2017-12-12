package ru.ifmo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class СамурайТренировкаEntityPK implements Serializable {
    private int idСамурай;
    private int idТренировка;

    @Column(name = "id_самурай", nullable = false)
    @Id
    public int getIdСамурай() {
        return idСамурай;
    }

    public void setIdСамурай(int idСамурай) {
        this.idСамурай = idСамурай;
    }

    @Column(name = "id_тренировка", nullable = false)
    @Id
    public int getIdТренировка() {
        return idТренировка;
    }

    public void setIdТренировка(int idТренировка) {
        this.idТренировка = idТренировка;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        СамурайТренировкаEntityPK that = (СамурайТренировкаEntityPK) o;

        if (idСамурай != that.idСамурай) return false;
        if (idТренировка != that.idТренировка) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idСамурай;
        result = 31 * result + idТренировка;
        return result;
    }
}
