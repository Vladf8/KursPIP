package ru.ifmo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Битва", schema = "public", catalog = "pip")
public class БитваEntity {
    private int id;
    private int idВойна;
    private Integer победившаяСторона;
    private Date дата;
    private ВойнаEntity войнаByIdВойна;
    private СторонаEntity сторонаByПобедившаяСторона;
    private Collection<СамурайБитваEntity> самурайБитваsById;
    private Collection<СторонаБитваEntity> сторонаБитваsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "Победившая_сторона", nullable = true)
    public Integer getПобедившаяСторона() {
        return победившаяСторона;
    }

    public void setПобедившаяСторона(Integer победившаяСторона) {
        this.победившаяСторона = победившаяСторона;
    }

    @Basic
    @Column(name = "Дата", nullable = false)
    public Date getДата() {
        return дата;
    }

    public void setДата(Date дата) {
        this.дата = дата;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        БитваEntity that = (БитваEntity) o;

        if (id != that.id) return false;
        if (idВойна != that.idВойна) return false;
        if (победившаяСторона != null ? !победившаяСторона.equals(that.победившаяСторона) : that.победившаяСторона != null)
            return false;
        if (дата != null ? !дата.equals(that.дата) : that.дата != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idВойна;
        result = 31 * result + (победившаяСторона != null ? победившаяСторона.hashCode() : 0);
        result = 31 * result + (дата != null ? дата.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_война", referencedColumnName = "id", nullable = false)
    public ВойнаEntity getВойнаByIdВойна() {
        return войнаByIdВойна;
    }

    public void setВойнаByIdВойна(ВойнаEntity войнаByIdВойна) {
        this.войнаByIdВойна = войнаByIdВойна;
    }

    @ManyToOne
    @JoinColumn(name = "Победившая_сторона", referencedColumnName = "id_сторона")
    public СторонаEntity getСторонаByПобедившаяСторона() {
        return сторонаByПобедившаяСторона;
    }

    public void setСторонаByПобедившаяСторона(СторонаEntity сторонаByПобедившаяСторона) {
        this.сторонаByПобедившаяСторона = сторонаByПобедившаяСторона;
    }

    @OneToMany(mappedBy = "битваByIdБитва")
    public Collection<СамурайБитваEntity> getСамурайБитваsById() {
        return самурайБитваsById;
    }

    public void setСамурайБитваsById(Collection<СамурайБитваEntity> самурайБитваsById) {
        this.самурайБитваsById = самурайБитваsById;
    }

    @OneToMany(mappedBy = "битваByIdБитва")
    public Collection<СторонаБитваEntity> getСторонаБитваsById() {
        return сторонаБитваsById;
    }

    public void setСторонаБитваsById(Collection<СторонаБитваEntity> сторонаБитваsById) {
        this.сторонаБитваsById = сторонаБитваsById;
    }
}
