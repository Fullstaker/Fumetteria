package school.devskill.fumetteria.service.interfaces;

import school.devskill.fumetteria.model.User;

import java.util.List;

public interface IUserService {

    List<User> getUtenti();

    User creaUtente(User nuovoUtente);

    User cancellaUtente(Integer id);

    User aggiornaUtente(User user);
}
