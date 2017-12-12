package ru.ifmo;

import javax.persistence.*;

@Entity
@Table(name = "Сторона_Битва", schema = "public", catalog = "pip")
@IdClass(СторонаБитваEntityPK.class)
public class СторонаБитваEntity {
    private int ааа;
    private int idСтороны;
    private int idБитва;
    private СторонаEntity сторонаByIdСтороны;
    private БитваEntity битваByIdБитва;

    @Basic
    @Column(name = "ааа", nullable = false)
    public int getАаа() {
        return ааа;
    }

    public void setАаа(int ааа) {
        this.ааа = ааа;
    }

    @Id
    @Column(name = "id_стороны", nullable = false)
    public int getIdСтороны() {
        return idСтороны;
    }

    public void setIdСтороны(int idСтороны) {
        this.idСтороны = idСтороны;
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

        СторонаБитваEntity that = (СторонаБитваEntity) o;

        if (ааа != that.ааа) return false;
        if (idСтороны != that.idСтороны) return false;
        if (idБитва != that.idБитва) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ааа;
        result = 31 * result + idСтороны;
        result = 31 * result + idБитва;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_стороны", referencedColumnName = "id_сторона", nullable = false)
    public СторонаEntity getСторонаByIdСтороны() {
        return сторонаByIdСтороны;
    }

    public void setСторонаByIdСтороны(СторонаEntity сторонаByIdСтороны) {
        this.сторонаByIdСтороны = сторонаByIdСтороны;
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
