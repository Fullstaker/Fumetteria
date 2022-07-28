package school.devskill.fumetteria.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import school.devskill.fumetteria.model.User;

public interface IUserRepository extends CrudRepository<User, Integer> {

}
