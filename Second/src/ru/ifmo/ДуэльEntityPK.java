package ru.ifmo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ДуэльEntityPK implements Serializable {
    private int первыйСамурай;
    private int второйСамурай;

    @Column(name = "Первый_самурай", nullable = false)
    @Id
    public int getПервыйСамурай() {
        return первыйСамурай;
    }

    public void setПервыйСамурай(int первыйСамурай) {
        this.первыйСамурай = первыйСамурай;
    }

    @Column(name = "Второй самурай", nullable = false)
    @Id
    public int getВторойСамурай() {
        return второйСамурай;
    }

    public void setВторойСамурай(int второйСамурай) {
        this.второйСамурай = второйСамурай;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ДуэльEntityPK that = (ДуэльEntityPK) o;

        if (первыйСамурай != that.первыйСамурай) return false;
        if (второйСамурай != that.второйСамурай) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = первыйСамурай;
        result = 31 * result + второйСамурай;
        return result;
    }
}
