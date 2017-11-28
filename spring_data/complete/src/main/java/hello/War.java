package hello;
import javax.persistence.*;

@Entity
@Table(name = "Война")
public class War {
    @Column(name = "id")
    private int id;
    @Column(name = "Начало")
    private String date_start;
    @Column(name = "Конец")
    private String date_end;
}
