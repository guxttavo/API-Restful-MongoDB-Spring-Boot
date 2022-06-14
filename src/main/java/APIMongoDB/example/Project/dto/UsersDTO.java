package APIMongoDB.example.Project.dto;

import APIMongoDB.example.Project.domain.Users;

import java.io.Serial;
import java.io.Serializable;

public class UsersDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UsersDTO() {
    }

    public UsersDTO(Users obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public UsersDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UsersDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsersDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
