package ru.ifmo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Додзё", schema = "public", catalog = "pip")
public class ДодзёEntity {
    private String название;
    private String описание;
    private Collection<ТренировкаEntity> тренировкаsByНазвание;

    @Id
    @Column(name = "Название", nullable = false, length = -1)
    public String getНазвание() {
        return название;
    }

    public void setНазвание(String название) {
        this.название = название;
    }

    @Basic
    @Column(name = "Описание", nullable = true, length = -1)
    public String getОписание() {
        return описание;
    }

    public void setОписание(String описание) {
        this.описание = описание;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ДодзёEntity that = (ДодзёEntity) o;

        if (название != null ? !название.equals(that.название) : that.название != null) return false;
        if (описание != null ? !описание.equals(that.описание) : that.описание != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = название != null ? название.hashCode() : 0;
        result = 31 * result + (описание != null ? описание.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "додзёByНазваниеДодзё")
    public Collection<ТренировкаEntity> getТренировкаsByНазвание() {
        return тренировкаsByНазвание;
    }

    public void setТренировкаsByНазвание(Collection<ТренировкаEntity> тренировкаsByНазвание) {
        this.тренировкаsByНазвание = тренировкаsByНазвание;
    }
}
