package ru.ifmo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Самурай", schema = "public", catalog = "pip")
public class СамурайEntity {
    private int id;
    private String имя;
    private short возраст;
    private short вес;
    private short рост;
    private boolean жив;
    private String названиеНадела;
    private String названиеКлана;
    private Collection<ДуэльEntity> дуэльsById;
    private Collection<ДуэльEntity> дуэльsById_0;
    private Collection<ИнвентарьEntity> инвентарьsById;
    private Collection<КланEntity> кланsById;
    private ЗемельныйНаделEntity земельныйНаделByНазваниеНадела;
    private КланEntity кланByНазваниеКлана;
    private Collection<СамурайБитваEntity> самурайБитваsById;
    private Collection<СамурайТренировкаEntity> самурайТренировкаsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Имя", nullable = false, length = -1)
    public String getИмя() {
        return имя;
    }

    public void setИмя(String имя) {
        this.имя = имя;
    }

    @Basic
    @Column(name = "Возраст", nullable = false)
    public short getВозраст() {
        return возраст;
    }

    public void setВозраст(short возраст) {
        this.возраст = возраст;
    }

    @Basic
    @Column(name = "Вес", nullable = false)
    public short getВес() {
        return вес;
    }

    public void setВес(short вес) {
        this.вес = вес;
    }

    @Basic
    @Column(name = "Рост", nullable = false)
    public short getРост() {
        return рост;
    }

    public void setРост(short рост) {
        this.рост = рост;
    }

    @Basic
    @Column(name = "Жив", nullable = false)
    public boolean isЖив() {
        return жив;
    }

    public void setЖив(boolean жив) {
        this.жив = жив;
    }

    @Basic
    @Column(name = "Название_надела", nullable = true, length = -1)
    public String getНазваниеНадела() {
        return названиеНадела;
    }

    public void setНазваниеНадела(String названиеНадела) {
        this.названиеНадела = названиеНадела;
    }

    @Basic
    @Column(name = "Название_клана", nullable = true, length = -1)
    public String getНазваниеКлана() {
        return названиеКлана;
    }

    public void setНазваниеКлана(String названиеКлана) {
        this.названиеКлана = названиеКлана;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        СамурайEntity that = (СамурайEntity) o;

        if (id != that.id) return false;
        if (возраст != that.возраст) return false;
        if (вес != that.вес) return false;
        if (рост != that.рост) return false;
        if (жив != that.жив) return false;
        if (имя != null ? !имя.equals(that.имя) : that.имя != null) return false;
        if (названиеНадела != null ? !названиеНадела.equals(that.названиеНадела) : that.названиеНадела != null)
            return false;
        if (названиеКлана != null ? !названиеКлана.equals(that.названиеКлана) : that.названиеКлана != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (имя != null ? имя.hashCode() : 0);
        result = 31 * result + (int) возраст;
        result = 31 * result + (int) вес;
        result = 31 * result + (int) рост;
        result = 31 * result + (жив ? 1 : 0);
        result = 31 * result + (названиеНадела != null ? названиеНадела.hashCode() : 0);
        result = 31 * result + (названиеКлана != null ? названиеКлана.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "самурайByПервыйСамурай")
    public Collection<ДуэльEntity> getДуэльsById() {
        return дуэльsById;
    }

    public void setДуэльsById(Collection<ДуэльEntity> дуэльsById) {
        this.дуэльsById = дуэльsById;
    }

    @OneToMany(mappedBy = "самурайByВторойСамурай")
    public Collection<ДуэльEntity> getДуэльsById_0() {
        return дуэльsById_0;
    }

    public void setДуэльsById_0(Collection<ДуэльEntity> дуэльsById_0) {
        this.дуэльsById_0 = дуэльsById_0;
    }

    @OneToMany(mappedBy = "самурайByIdХозяин")
    public Collection<ИнвентарьEntity> getИнвентарьsById() {
        return инвентарьsById;
    }

    public void setИнвентарьsById(Collection<ИнвентарьEntity> инвентарьsById) {
        this.инвентарьsById = инвентарьsById;
    }

    @OneToMany(mappedBy = "самурайByIdГлава")
    public Collection<КланEntity> getКланsById() {
        return кланsById;
    }

    public void setКланsById(Collection<КланEntity> кланsById) {
        this.кланsById = кланsById;
    }

    @ManyToOne
    @JoinColumn(name = "Название_надела", referencedColumnName = "Название")
    public ЗемельныйНаделEntity getЗемельныйНаделByНазваниеНадела() {
        return земельныйНаделByНазваниеНадела;
    }

    public void setЗемельныйНаделByНазваниеНадела(ЗемельныйНаделEntity земельныйНаделByНазваниеНадела) {
        this.земельныйНаделByНазваниеНадела = земельныйНаделByНазваниеНадела;
    }

    @ManyToOne
    @JoinColumn(name = "Название_клана", referencedColumnName = "Название")
    public КланEntity getКланByНазваниеКлана() {
        return кланByНазваниеКлана;
    }

    public void setКланByНазваниеКлана(КланEntity кланByНазваниеКлана) {
        this.кланByНазваниеКлана = кланByНазваниеКлана;
    }

    @OneToMany(mappedBy = "самурайByIdСамурай")
    public Collection<СамурайБитваEntity> getСамурайБитваsById() {
        return самурайБитваsById;
    }

    public void setСамурайБитваsById(Collection<СамурайБитваEntity> самурайБитваsById) {
        this.самурайБитваsById = самурайБитваsById;
    }

    @OneToMany(mappedBy = "самурайByIdСамурай")
    public Collection<СамурайТренировкаEntity> getСамурайТренировкаsById() {
        return самурайТренировкаsById;
    }

    public void setСамурайТренировкаsById(Collection<СамурайТренировкаEntity> самурайТренировкаsById) {
        this.самурайТренировкаsById = самурайТренировкаsById;
    }
}
