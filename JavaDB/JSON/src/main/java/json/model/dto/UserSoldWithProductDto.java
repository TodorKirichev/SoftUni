package json.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserSoldWithProductDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private ProductSoldDto productSoldDtos;

    public ProductSoldDto getProductSoldDtos() {
        return productSoldDtos;
    }

    public void setProductSoldDtos(ProductSoldDto productSoldDtos) {
        this.productSoldDtos = productSoldDtos;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
