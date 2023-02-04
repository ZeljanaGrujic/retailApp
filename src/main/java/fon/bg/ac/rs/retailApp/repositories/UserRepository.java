package fon.bg.ac.rs.retailApp.repositories;

import fon.bg.ac.rs.retailApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
