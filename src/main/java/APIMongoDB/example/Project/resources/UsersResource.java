package APIMongoDB.example.Project.resources;

import APIMongoDB.example.Project.domain.Users;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        Users gustavo = new Users("1", "Gustavo", "gus@gus.com");
        Users elias = new Users("2", "elias", "eli@eli.com");
        List<Users> list = new ArrayList<>();
        list.addAll(Arrays.asList(gustavo, elias));
        return ResponseEntity.ok().body(list);
    }


}
