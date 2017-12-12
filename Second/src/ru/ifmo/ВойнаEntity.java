package ru.ifmo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Война", schema = "public", catalog = "pip")
public class ВойнаEntity {
    private int id;
    private Date начало;
    private Date конец;
    private Collection<БитваEntity> битваsById;
    private Collection<СторонаEntity> сторонаsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Начало", nullable = false)
    public Date getНачало() {
        return начало;
    }

    public void setНачало(Date начало) {
        this.начало = начало;
    }

    @Basic
    @Column(name = "Конец", nullable = true)
    public Date getКонец() {
        return конец;
    }

    public void setКонец(Date конец) {
        this.конец = конец;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ВойнаEntity that = (ВойнаEntity) o;

        if (id != that.id) return false;
        if (начало != null ? !начало.equals(that.начало) : that.начало != null) return false;
        if (конец != null ? !конец.equals(that.конец) : that.конец != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (начало != null ? начало.hashCode() : 0);
        result = 31 * result + (конец != null ? конец.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "войнаByIdВойна")
    public Collection<БитваEntity> getБитваsById() {
        return битваsById;
    }

    public void setБитваsById(Collection<БитваEntity> битваsById) {
        this.битваsById = битваsById;
    }

    @OneToMany(mappedBy = "войнаByIdВойна")
    public Collection<СторонаEntity> getСторонаsById() {
        return сторонаsById;
    }

    public void setСторонаsById(Collection<СторонаEntity> сторонаsById) {
        this.сторонаsById = сторонаsById;
    }
}
