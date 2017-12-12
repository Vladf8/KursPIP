package ru.ifmo;

import javax.persistence.*;

@Entity
@Table(name = "Инвентарь", schema = "public", catalog = "pip")
public class ИнвентарьEntity {
    private int id;
    private int idХозяин;
    private String название;
    private СамурайEntity самурайByIdХозяин;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_хозяин", nullable = false)
    public int getIdХозяин() {
        return idХозяин;
    }

    public void setIdХозяин(int idХозяин) {
        this.idХозяин = idХозяин;
    }

    @Basic
    @Column(name = "Название", nullable = false, length = -1)
    public String getНазвание() {
        return название;
    }

    public void setНазвание(String название) {
        this.название = название;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ИнвентарьEntity that = (ИнвентарьEntity) o;

        if (id != that.id) return false;
        if (idХозяин != that.idХозяин) return false;
        if (название != null ? !название.equals(that.название) : that.название != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idХозяин;
        result = 31 * result + (название != null ? название.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_хозяин", referencedColumnName = "id", nullable = false)
    public СамурайEntity getСамурайByIdХозяин() {
        return самурайByIdХозяин;
    }

    public void setСамурайByIdХозяин(СамурайEntity самурайByIdХозяин) {
        this.самурайByIdХозяин = самурайByIdХозяин;
    }
}
