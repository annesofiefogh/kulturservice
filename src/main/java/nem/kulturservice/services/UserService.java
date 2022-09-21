package nem.kulturservice.services;

import nem.kulturservice.models.User;
import org.springframework.stereotype.Service;
import nem.kulturservice.repositories.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service //gør at spring "ser" denne klasse
public class UserService implements IUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        Set<User> set = new HashSet<>();
        userRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }
}
