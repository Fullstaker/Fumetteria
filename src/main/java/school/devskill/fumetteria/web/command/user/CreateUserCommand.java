package school.devskill.fumetteria.web.command.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCommand {

    private String name;
    private String surname;
    private String username;
    private String password;

}
