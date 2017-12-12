package ru.ifmo;

import javax.persistence.*;

@Entity
@Table(name = "Клан_Сторона", schema = "public", catalog = "pip")
@IdClass(КланСторонаEntityPK.class)
public class КланСторонаEntity {
    private String названиеКлана;
    private int idСтороны;
    private КланEntity кланByНазваниеКлана;
    private СторонаEntity сторонаByIdСтороны;

    @Id
    @Column(name = "Название_клана", nullable = false, length = -1)
    public String getНазваниеКлана() {
        return названиеКлана;
    }

    public void setНазваниеКлана(String названиеКлана) {
        this.названиеКлана = названиеКлана;
    }

    @Id
    @Column(name = "id_стороны", nullable = false)
    public int getIdСтороны() {
        return idСтороны;
    }

    public void setIdСтороны(int idСтороны) {
        this.idСтороны = idСтороны;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        КланСторонаEntity that = (КланСторонаEntity) o;

        if (idСтороны != that.idСтороны) return false;
        if (названиеКлана != null ? !названиеКлана.equals(that.названиеКлана) : that.названиеКлана != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = названиеКлана != null ? названиеКлана.hashCode() : 0;
        result = 31 * result + idСтороны;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Название_клана", referencedColumnName = "Название", nullable = false)
    public КланEntity getКланByНазваниеКлана() {
        return кланByНазваниеКлана;
    }

    public void setКланByНазваниеКлана(КланEntity кланByНазваниеКлана) {
        this.кланByНазваниеКлана = кланByНазваниеКлана;
    }

    @ManyToOne
    @JoinColumn(name = "id_стороны", referencedColumnName = "id_сторона", nullable = false)
    public СторонаEntity getСторонаByIdСтороны() {
        return сторонаByIdСтороны;
    }

    public void setСторонаByIdСтороны(СторонаEntity сторонаByIdСтороны) {
        this.сторонаByIdСтороны = сторонаByIdСтороны;
    }
}
