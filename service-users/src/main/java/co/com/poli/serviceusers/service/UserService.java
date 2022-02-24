package co.com.poli.serviceusers.service;

import co.com.poli.serviceusers.entities.Users;

import java.util.List;

public interface UserService {

    public List<Users> listAllUser();

    public Users createUser(Users user);

    public void deleteUser(Long id);

    public Users getUserById(Long id);

}
