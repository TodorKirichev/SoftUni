package json.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserAndProductsDto {

    @Expose
    private int usersCount;

    public List<UserSoldWithProductDto> getUserSoldWithProductDtos() {
        return userSoldWithProductDtos;
    }

    public void setUserSoldWithProductDtos(List<UserSoldWithProductDto> userSoldWithProductDtos) {
        this.userSoldWithProductDtos = userSoldWithProductDtos;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    @Expose
    private List<UserSoldWithProductDto> userSoldWithProductDtos;
}
