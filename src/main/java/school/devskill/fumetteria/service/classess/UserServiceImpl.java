package school.devskill.fumetteria.service.classess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.devskill.fumetteria.model.User;
import school.devskill.fumetteria.persistence.repository.IUserRepository;
import school.devskill.fumetteria.service.interfaces.IUserService;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUtenti() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User creaUtente(User nuovoUtente) {
        return userRepository.save(nuovoUtente);
    }

    @Override
    public User cancellaUtente(Integer id) {
        User daCancellare;

        try {
            daCancellare = userRepository.findById(id).get();
            userRepository.delete(daCancellare);

        } catch (NoSuchElementException e) {
            daCancellare = new User();
        }
        return daCancellare;
    }

    @Override
    public User aggiornaUtente(User userAggiornato) {
        User utenteCorrente = userRepository.findById(userAggiornato.getId()).get();

        if( userAggiornato.getName() != null){
            utenteCorrente.setName(userAggiornato.getName());
        }
        if( userAggiornato.getSurname() != null){
            utenteCorrente.setSurname(userAggiornato.getSurname());
        }
        if( userAggiornato.getPassword() != null){
            utenteCorrente.setPassword(userAggiornato.getPassword());
        }
        if( userAggiornato.getUsername() != null){
            utenteCorrente.setUsername(userAggiornato.getUsername());
        }

        return userRepository.save(utenteCorrente);
    }
}