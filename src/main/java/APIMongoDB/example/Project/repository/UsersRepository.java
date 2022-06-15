package APIMongoDB.example.Project.repository;

import APIMongoDB.example.Project.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

    void delete(String id);
}
