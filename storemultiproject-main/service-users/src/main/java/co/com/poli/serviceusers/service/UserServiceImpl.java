package co.com.poli.serviceusers.service;

import co.com.poli.serviceusers.entities.Users;
import co.com.poli.serviceusers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{

    // agregar inyeccion de dependencias

    private final UserRepository userRepository;

    @Override
    public List<Users> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
