package school.devskill.fumetteria.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.devskill.fumetteria.model.User;
import school.devskill.fumetteria.service.interfaces.IUserService;
import school.devskill.fumetteria.web.command.user.CreateUserCommand;
import school.devskill.fumetteria.web.command.user.UpdateUserCommand;
import school.devskill.fumetteria.web.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;
    private final ObjectMapper mapper;

    @Autowired
    public UserController(IUserService userService, ObjectMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }


    @PutMapping("/update/{id}")
    public UserDTO aggiornaUtente(@PathVariable Integer id, @RequestBody UpdateUserCommand command) {
        User daModificare = mapper.convertValue(command, User.class);
        daModificare.setId(id);
        return mapper.convertValue(userService.aggiornaUtente(daModificare),UserDTO.class);
    }


    @GetMapping("/users")
    public List<UserDTO> listaUtenti() {

        List<User> utentiDalDb = userService.getUtenti();

        List<UserDTO> ritorno = new ArrayList<>();

        for (int i = 0; i < utentiDalDb.size(); i++) {
            try {
                ritorno.add(mapper.convertValue(utentiDalDb.get(i), UserDTO.class));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return ritorno;
    }

    @PostMapping("/create")
    public UserDTO creaUtente(@RequestBody CreateUserCommand command) {
        User nuovoUtente = mapper.convertValue(command, User.class);
        return mapper.convertValue(userService.creaUtente(nuovoUtente), UserDTO.class);
    }


    @DeleteMapping("/delete/{id}")
    public UserDTO cancellaUtente(@PathVariable Integer id) {
        return mapper.convertValue(userService.cancellaUtente(id), UserDTO.class);

    }

}
