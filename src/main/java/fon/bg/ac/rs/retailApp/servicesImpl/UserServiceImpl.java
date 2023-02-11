package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.User;
import fon.bg.ac.rs.retailApp.repositories.UserRepository;
import fon.bg.ac.rs.retailApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByFirstnameAndLastname(String firstname, String lastname) {
        return userRepository.findByFirstnameAndLastname(firstname, lastname);
    }

}
