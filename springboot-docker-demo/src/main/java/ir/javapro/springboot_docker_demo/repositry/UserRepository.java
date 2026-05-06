package ir.javapro.springboot_docker_demo.repositry;

import ir.javapro.springboot_docker_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
