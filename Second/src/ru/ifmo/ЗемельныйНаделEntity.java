package ru.ifmo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Земельный_надел", schema = "public", catalog = "pip")
public class ЗемельныйНаделEntity {
    private String название;
    private String названиеКлан;
    private КланEntity кланByНазваниеКлан;
    private Collection<СамурайEntity> самурайsByНазвание;

    @Id
    @Column(name = "Название", nullable = false, length = -1)
    public String getНазвание() {
        return название;
    }

    public void setНазвание(String название) {
        this.название = название;
    }

    @Basic
    @Column(name = "Название_клан", nullable = true, length = -1)
    public String getНазваниеКлан() {
        return названиеКлан;
    }

    public void setНазваниеКлан(String названиеКлан) {
        this.названиеКлан = названиеКлан;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ЗемельныйНаделEntity that = (ЗемельныйНаделEntity) o;

        if (название != null ? !название.equals(that.название) : that.название != null) return false;
        if (названиеКлан != null ? !названиеКлан.equals(that.названиеКлан) : that.названиеКлан != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = название != null ? название.hashCode() : 0;
        result = 31 * result + (названиеКлан != null ? названиеКлан.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Название_клан", referencedColumnName = "Название")
    public КланEntity getКланByНазваниеКлан() {
        return кланByНазваниеКлан;
    }

    public void setКланByНазваниеКлан(КланEntity кланByНазваниеКлан) {
        this.кланByНазваниеКлан = кланByНазваниеКлан;
    }

    @OneToMany(mappedBy = "земельныйНаделByНазваниеНадела")
    public Collection<СамурайEntity> getСамурайsByНазвание() {
        return самурайsByНазвание;
    }

    public void setСамурайsByНазвание(Collection<СамурайEntity> самурайsByНазвание) {
        this.самурайsByНазвание = самурайsByНазвание;
    }
}
