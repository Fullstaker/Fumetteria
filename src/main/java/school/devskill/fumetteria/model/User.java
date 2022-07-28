package school.devskill.fumetteria.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(length = 100,nullable = false)
    private String surname;

    @Column(length = 100,nullable = false)
    private String username;

    @Column(length = 100,nullable = false)
    private String password;

}
