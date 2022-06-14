package APIMongoDB.example.Project.resources;

import APIMongoDB.example.Project.domain.Users;
import APIMongoDB.example.Project.dto.UsersDTO;
import APIMongoDB.example.Project.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    @Autowired
    private UsersService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsersDTO>> findAll() {
        List<Users> list = service.findAll();
        List<UsersDTO> listDto = list.stream().map(x -> new UsersDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsersDTO> findById(@PathVariable String id) {
        Users obj = service.findById(id);

        return ResponseEntity.ok().body(new UsersDTO(obj));
    }


}
