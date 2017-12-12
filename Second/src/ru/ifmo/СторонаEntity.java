package ru.ifmo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Сторона", schema = "public", catalog = "pip")
public class СторонаEntity {
    private int idСторона;
    private int idВойна;
    private boolean статус;
    private Collection<БитваEntity> битваsByIdСторона;
    private Collection<КланСторонаEntity> кланСторонаsByIdСторона;
    private ВойнаEntity войнаByIdВойна;
    private Collection<СторонаБитваEntity> сторонаБитваsByIdСторона;

    @Id
    @Column(name = "id_сторона", nullable = false)
    public int getIdСторона() {
        return idСторона;
    }

    public void setIdСторона(int idСторона) {
        this.idСторона = idСторона;
    }

    @Basic
    @Column(name = "id_война", nullable = false)
    public int getIdВойна() {
        return idВойна;
    }

    public void setIdВойна(int idВойна) {
        this.idВойна = idВойна;
    }

    @Basic
    @Column(name = "Статус", nullable = false)
    public boolean isСтатус() {
        return статус;
    }

    public void setСтатус(boolean статус) {
        this.статус = статус;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        СторонаEntity that = (СторонаEntity) o;

        if (idСторона != that.idСторона) return false;
        if (idВойна != that.idВойна) return false;
        if (статус != that.статус) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idСторона;
        result = 31 * result + idВойна;
        result = 31 * result + (статус ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "сторонаByПобедившаяСторона")
    public Collection<БитваEntity> getБитваsByIdСторона() {
        return битваsByIdСторона;
    }

    public void setБитваsByIdСторона(Collection<БитваEntity> битваsByIdСторона) {
        this.битваsByIdСторона = битваsByIdСторона;
    }

    @OneToMany(mappedBy = "сторонаByIdСтороны")
    public Collection<КланСторонаEntity> getКланСторонаsByIdСторона() {
        return кланСторонаsByIdСторона;
    }

    public void setКланСторонаsByIdСторона(Collection<КланСторонаEntity> кланСторонаsByIdСторона) {
        this.кланСторонаsByIdСторона = кланСторонаsByIdСторона;
    }

    @ManyToOne
    @JoinColumn(name = "id_война", referencedColumnName = "id", nullable = false)
    public ВойнаEntity getВойнаByIdВойна() {
        return войнаByIdВойна;
    }

    public void setВойнаByIdВойна(ВойнаEntity войнаByIdВойна) {
        this.войнаByIdВойна = войнаByIdВойна;
    }

    @OneToMany(mappedBy = "сторонаByIdСтороны")
    public Collection<СторонаБитваEntity> getСторонаБитваsByIdСторона() {
        return сторонаБитваsByIdСторона;
    }

    public void setСторонаБитваsByIdСторона(Collection<СторонаБитваEntity> сторонаБитваsByIdСторона) {
        this.сторонаБитваsByIdСторона = сторонаБитваsByIdСторона;
    }
}
