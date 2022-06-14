package APIMongoDB.example.Project.services;

import APIMongoDB.example.Project.domain.Users;
import APIMongoDB.example.Project.repository.UsersRepository;
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



}
