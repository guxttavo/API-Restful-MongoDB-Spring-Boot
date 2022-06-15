package APIMongoDB.example.Project.resources;

import APIMongoDB.example.Project.domain.Users;
import APIMongoDB.example.Project.dto.UsersDTO;
import APIMongoDB.example.Project.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UsersDTO objDTo) {
        Users obj = service.fromDTO(objDTo);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UsersDTO> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UsersDTO objDTo, @PathVariable String id) {
        Users obj = service.fromDTO(objDTo);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

}
