package ru.ifmo;

import javax.persistence.*;

@Entity
@Table(name = "Дуэль", schema = "public", catalog = "pip")
@IdClass(ДуэльEntityPK.class)
public class ДуэльEntity {
    private int первыйСамурай;
    private int второйСамурай;
    private Integer idПобедивший;
    private СамурайEntity самурайByПервыйСамурай;
    private СамурайEntity самурайByВторойСамурай;

    @Id
    @Column(name = "Первый_самурай", nullable = false)
    public int getПервыйСамурай() {
        return первыйСамурай;
    }

    public void setПервыйСамурай(int первыйСамурай) {
        this.первыйСамурай = первыйСамурай;
    }

    @Id
    @Column(name = "Второй самурай", nullable = false)
    public int getВторойСамурай() {
        return второйСамурай;
    }

    public void setВторойСамурай(int второйСамурай) {
        this.второйСамурай = второйСамурай;
    }

    @Basic
    @Column(name = "Id_победивший", nullable = true)
    public Integer getIdПобедивший() {
        return idПобедивший;
    }

    public void setIdПобедивший(Integer idПобедивший) {
        this.idПобедивший = idПобедивший;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ДуэльEntity that = (ДуэльEntity) o;

        if (первыйСамурай != that.первыйСамурай) return false;
        if (второйСамурай != that.второйСамурай) return false;
        if (idПобедивший != null ? !idПобедивший.equals(that.idПобедивший) : that.idПобедивший != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = первыйСамурай;
        result = 31 * result + второйСамурай;
        result = 31 * result + (idПобедивший != null ? idПобедивший.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Первый_самурай", referencedColumnName = "id", nullable = false)
    public СамурайEntity getСамурайByПервыйСамурай() {
        return самурайByПервыйСамурай;
    }

    public void setСамурайByПервыйСамурай(СамурайEntity самурайByПервыйСамурай) {
        this.самурайByПервыйСамурай = самурайByПервыйСамурай;
    }

    @ManyToOne
    @JoinColumn(name = "Второй самурай", referencedColumnName = "id", nullable = false)
    public СамурайEntity getСамурайByВторойСамурай() {
        return самурайByВторойСамурай;
    }

    public void setСамурайByВторойСамурай(СамурайEntity самурайByВторойСамурай) {
        this.самурайByВторойСамурай = самурайByВторойСамурай;
    }
}
