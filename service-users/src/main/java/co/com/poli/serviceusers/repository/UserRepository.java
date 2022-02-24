package co.com.poli.serviceusers.repository;

import co.com.poli.serviceusers.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> { }
