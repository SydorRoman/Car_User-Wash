package entity;

import lombok.*;

import javax.persistence.*;

import lombok.Builder;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString(exclude = {"passport", "cars"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surName;
    private int age;
    private String sex;
    private String email;


    @OneToOne(
//            fetch = FetchType.EAGER витягти зразу з паспортм
//            fetch = FetchType.LAZY без паспорта
            fetch = FetchType.LAZY,
            cascade = {
//                    CascadeType.ALL,
//                    CascadeType.DETACH
//                    CascadeType.MERGE
//                    CascadeType.PERSIST
//                    CascadeType.REFRESH
//                    CascadeType.REMOVE  видалення юзера - видалення паспорта
                    CascadeType.ALL
            },
            mappedBy = "user"
    )
    private Passport passport;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user"
    )
    private List<Car> cars;

}
