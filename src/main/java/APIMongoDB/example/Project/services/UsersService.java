package APIMongoDB.example.Project.services;

import APIMongoDB.example.Project.domain.Users;
import APIMongoDB.example.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepository repo;

    public List<Users> findAll() {
        return repo.findAll();

    }



}
