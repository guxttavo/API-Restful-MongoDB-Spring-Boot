package APIMongoDB.example.Project.services;

import APIMongoDB.example.Project.domain.Users;
import APIMongoDB.example.Project.dto.UsersDTO;
import APIMongoDB.example.Project.repository.UsersRepository;
import APIMongoDB.example.Project.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repo;

    public List<Users> findAll() {
        return repo.findAll();

    }

    public Users findById(String id) {
        Users user = repo.findOne(id);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado!");
        }
        return user;
    }

    public Users insert(Users obj) {
        return repo.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repo.delete(id);
    }

    public Users fromDTO(UsersDTO objDto) {
        return new Users(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
