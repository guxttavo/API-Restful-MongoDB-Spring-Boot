package APIMongoDB.example.Project.config;

import APIMongoDB.example.Project.domain.Users;
import APIMongoDB.example.Project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {

        usersRepository.deleteAll();

        Users maria = new Users(null, "Maria Brown", "maria@gmail.com");
        Users alex = new Users(null, "Alex Green", "alex@gmail.com");
        Users bob = new Users(null, "Bob Grey", "bob@gmail.com");

        usersRepository.saveAll(Arrays.asList(maria, alex, bob));
        //usersRepository.save(Arrays.asList(maria, alex, bob));
    }
}
