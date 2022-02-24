package co.com.poli.servicebookings.client;

import co.com.poli.servicebookings.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="user-service")
@RequestMapping(value="/users")
public interface UserClient {

    @GetMapping(value = "/{idUser}")
    public ResponseEntity<Users> getUser(@PathVariable("idUser") Long idUser);

}
