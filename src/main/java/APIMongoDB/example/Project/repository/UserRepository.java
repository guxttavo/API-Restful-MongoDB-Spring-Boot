package APIMongoDB.example.Project.repository;

import APIMongoDB.example.Project.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {

}
