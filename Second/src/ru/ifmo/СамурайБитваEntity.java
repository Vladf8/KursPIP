package ru.ifmo;

import javax.persistence.*;

@Entity
@Table(name = "Самурай_Битва", schema = "public", catalog = "pip")
@IdClass(СамурайБитваEntityPK.class)
public class СамурайБитваEntity {
    private int idСамурай;
    private int idБитва;
    private СамурайEntity самурайByIdСамурай;
    private БитваEntity битваByIdБитва;

    @Id
    @Column(name = "id_самурай", nullable = false)
    public int getIdСамурай() {
        return idСамурай;
    }

    public void setIdСамурай(int idСамурай) {
        this.idСамурай = idСамурай;
    }

    @Id
    @Column(name = "id_битва", nullable = false)
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

        СамурайБитваEntity that = (СамурайБитваEntity) o;

        if (idСамурай != that.idСамурай) return false;
        if (idБитва != that.idБитва) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idСамурай;
        result = 31 * result + idБитва;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_самурай", referencedColumnName = "id", nullable = false)
    public СамурайEntity getСамурайByIdСамурай() {
        return самурайByIdСамурай;
    }

    public void setСамурайByIdСамурай(СамурайEntity самурайByIdСамурай) {
        this.самурайByIdСамурай = самурайByIdСамурай;
    }

    @ManyToOne
    @JoinColumn(name = "id_битва", referencedColumnName = "id", nullable = false)
    public БитваEntity getБитваByIdБитва() {
        return битваByIdБитва;
    }

    public void setБитваByIdБитва(БитваEntity битваByIdБитва) {
        this.битваByIdБитва = битваByIdБитва;
    }
}
