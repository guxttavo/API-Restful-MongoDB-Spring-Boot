package APIMongoDB.example.Project.resources;

import APIMongoDB.example.Project.domain.Users;
import APIMongoDB.example.Project.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    @Autowired
    private UsersService service;

    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        List<Users> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


}
