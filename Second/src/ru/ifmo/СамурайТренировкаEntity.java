package ru.ifmo;

import javax.persistence.*;

@Entity
@Table(name = "Самурай_Тренировка", schema = "public", catalog = "pip")
@IdClass(СамурайТренировкаEntityPK.class)
public class СамурайТренировкаEntity {
    private int idСамурай;
    private int idТренировка;
    private СамурайEntity самурайByIdСамурай;
    private ТренировкаEntity тренировкаByIdТренировка;

    @Id
    @Column(name = "id_самурай", nullable = false)
    public int getIdСамурай() {
        return idСамурай;
    }

    public void setIdСамурай(int idСамурай) {
        this.idСамурай = idСамурай;
    }

    @Id
    @Column(name = "id_тренировка", nullable = false)
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

        СамурайТренировкаEntity that = (СамурайТренировкаEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "id_самурай", referencedColumnName = "id", nullable = false)
    public СамурайEntity getСамурайByIdСамурай() {
        return самурайByIdСамурай;
    }

    public void setСамурайByIdСамурай(СамурайEntity самурайByIdСамурай) {
        this.самурайByIdСамурай = самурайByIdСамурай;
    }

    @ManyToOne
    @JoinColumn(name = "id_тренировка", referencedColumnName = "id", nullable = false)
    public ТренировкаEntity getТренировкаByIdТренировка() {
        return тренировкаByIdТренировка;
    }

    public void setТренировкаByIdТренировка(ТренировкаEntity тренировкаByIdТренировка) {
        this.тренировкаByIdТренировка = тренировкаByIdТренировка;
    }
}
