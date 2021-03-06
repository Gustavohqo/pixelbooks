package br.com.pixelbooks.app.repository;

import br.com.pixelbooks.app.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);

    Boolean existsByUsername(String username);

    User findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
}