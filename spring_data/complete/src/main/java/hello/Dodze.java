package hello;

import javax.persistence.*;

@Entity
@Table(name = "Додзё")
public class Dodze {
    @Column(name = "Название")
    private String name;
    @Column(name = "Описание")
    private String description;
}
