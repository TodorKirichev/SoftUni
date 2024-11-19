package exercisespringdataautomappingobjects.xmlexercise.model.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlElement(name = "user")
    private List<UserWithProducts> users;

    public List<UserWithProducts> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithProducts> users) {
        this.users = users;
    }
}
