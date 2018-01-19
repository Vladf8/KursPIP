package ru.ifmo.samuraiWorld.data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class War {
    private int id;
    private Date start;
    private Date end;
    private Battle battleById;
    private Collection<Side> sidesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start", nullable = false)
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @Basic
    @Column(name = "end", nullable = true)
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        War war = (War) o;

        if (id != war.id) return false;
        if (start != null ? !start.equals(war.start) : war.start != null) return false;
        if (end != null ? !end.equals(war.end) : war.end != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "warById")
    public Battle getBattleById() {
        return battleById;
    }

    public void setBattleById(Battle battleById) {
        this.battleById = battleById;
    }

    @OneToMany(mappedBy = "warByIdWar")
    public Collection<Side> getSidesById() {
        return sidesById;
    }

    public void setSidesById(Collection<Side> sidesById) {
        this.sidesById = sidesById;
    }
}
