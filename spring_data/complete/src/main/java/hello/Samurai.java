package hello;
import javax.persistence.*;


@Entity
@Table(name = "Самурай")
public class Samurai {
    @Column(name = "id")
    private int id;
    @Column(name = "Имя")
    private String name;
    @Column(name = "Возраст")
    private int age;
    @Column(name = "Вес")
    private int weight;
    @Column(name = "Рост")
    private int height;
    @Column(name = "Навык")
    private int strenth;
    @Column(name = "Жив")
    private boolean alive;

}
