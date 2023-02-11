package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.User;

public interface UserService {
    User saveUser(User user);

    User findByUsername(String username);

    User findByFirstnameAndLastname(String firstname, String lastname);
}
