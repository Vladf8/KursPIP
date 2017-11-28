package hello;
import javax.persistence.*;

@Entity
@Table(name = "Клан")
public class Clan {
    @Column(name = "Название")
    private String name;
    @Column(name = "Родовой_знак")
    private String symbol;
    @OneToMany
    @JoinColumn(name = "id_глава")
    private int id_head;




}
