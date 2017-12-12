package ru.ifmo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Клан", schema = "public", catalog = "pip")
public class КланEntity {
    private String название;
    private String родовойЗнак;
    private int idГлава;
    private Collection<ЗемельныйНаделEntity> земельныйНаделsByНазвание;
    private СамурайEntity самурайByIdГлава;
    private Collection<КланСторонаEntity> кланСторонаsByНазвание;
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
    @Column(name = "Родовой_знак", nullable = false, length = -1)
    public String getРодовойЗнак() {
        return родовойЗнак;
    }

    public void setРодовойЗнак(String родовойЗнак) {
        this.родовойЗнак = родовойЗнак;
    }

    @Basic
    @Column(name = "id_глава", nullable = false)
    public int getIdГлава() {
        return idГлава;
    }

    public void setIdГлава(int idГлава) {
        this.idГлава = idГлава;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        КланEntity that = (КланEntity) o;

        if (idГлава != that.idГлава) return false;
        if (название != null ? !название.equals(that.название) : that.название != null) return false;
        if (родовойЗнак != null ? !родовойЗнак.equals(that.родовойЗнак) : that.родовойЗнак != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = название != null ? название.hashCode() : 0;
        result = 31 * result + (родовойЗнак != null ? родовойЗнак.hashCode() : 0);
        result = 31 * result + idГлава;
        return result;
    }

    @OneToMany(mappedBy = "кланByНазваниеКлан")
    public Collection<ЗемельныйНаделEntity> getЗемельныйНаделsByНазвание() {
        return земельныйНаделsByНазвание;
    }

    public void setЗемельныйНаделsByНазвание(Collection<ЗемельныйНаделEntity> земельныйНаделsByНазвание) {
        this.земельныйНаделsByНазвание = земельныйНаделsByНазвание;
    }

    @ManyToOne
    @JoinColumn(name = "id_глава", referencedColumnName = "id", nullable = false)
    public СамурайEntity getСамурайByIdГлава() {
        return самурайByIdГлава;
    }

    public void setСамурайByIdГлава(СамурайEntity самурайByIdГлава) {
        this.самурайByIdГлава = самурайByIdГлава;
    }

    @OneToMany(mappedBy = "кланByНазваниеКлана")
    public Collection<КланСторонаEntity> getКланСторонаsByНазвание() {
        return кланСторонаsByНазвание;
    }

    public void setКланСторонаsByНазвание(Collection<КланСторонаEntity> кланСторонаsByНазвание) {
        this.кланСторонаsByНазвание = кланСторонаsByНазвание;
    }

    @OneToMany(mappedBy = "кланByНазваниеКлана")
    public Collection<СамурайEntity> getСамурайsByНазвание() {
        return самурайsByНазвание;
    }

    public void setСамурайsByНазвание(Collection<СамурайEntity> самурайsByНазвание) {
        this.самурайsByНазвание = самурайsByНазвание;
    }
}
