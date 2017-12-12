package ru.ifmo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Тренировка", schema = "public", catalog = "pip")
public class ТренировкаEntity {
    private int id;
    private String названиеДодзё;
    private Date время;
    private Collection<СамурайТренировкаEntity> самурайТренировкаsById;
    private ДодзёEntity додзёByНазваниеДодзё;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Название_додзё", nullable = false, length = -1)
    public String getНазваниеДодзё() {
        return названиеДодзё;
    }

    public void setНазваниеДодзё(String названиеДодзё) {
        this.названиеДодзё = названиеДодзё;
    }

    @Basic
    @Column(name = "Время", nullable = false)
    public Date getВремя() {
        return время;
    }

    public void setВремя(Date время) {
        this.время = время;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ТренировкаEntity that = (ТренировкаEntity) o;

        if (id != that.id) return false;
        if (названиеДодзё != null ? !названиеДодзё.equals(that.названиеДодзё) : that.названиеДодзё != null)
            return false;
        if (время != null ? !время.equals(that.время) : that.время != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (названиеДодзё != null ? названиеДодзё.hashCode() : 0);
        result = 31 * result + (время != null ? время.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "тренировкаByIdТренировка")
    public Collection<СамурайТренировкаEntity> getСамурайТренировкаsById() {
        return самурайТренировкаsById;
    }

    public void setСамурайТренировкаsById(Collection<СамурайТренировкаEntity> самурайТренировкаsById) {
        this.самурайТренировкаsById = самурайТренировкаsById;
    }

    @ManyToOne
    @JoinColumn(name = "Название_додзё", referencedColumnName = "Название", nullable = false)
    public ДодзёEntity getДодзёByНазваниеДодзё() {
        return додзёByНазваниеДодзё;
    }

    public void setДодзёByНазваниеДодзё(ДодзёEntity додзёByНазваниеДодзё) {
        this.додзёByНазваниеДодзё = додзёByНазваниеДодзё;
    }
}
