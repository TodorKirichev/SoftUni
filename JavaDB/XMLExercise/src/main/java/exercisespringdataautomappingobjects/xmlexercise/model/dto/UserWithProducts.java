package exercisespringdataautomappingobjects.xmlexercise.model.dto;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithProducts {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private List<ProductWithBuyerDto> soldProducts;

    public List<ProductWithBuyerDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductWithBuyerDto> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
