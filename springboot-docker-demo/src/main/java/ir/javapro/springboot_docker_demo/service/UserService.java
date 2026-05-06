package ir.javapro.springboot_docker_demo.service;

import ir.javapro.springboot_docker_demo.entity.User;
import ir.javapro.springboot_docker_demo.repositry.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
