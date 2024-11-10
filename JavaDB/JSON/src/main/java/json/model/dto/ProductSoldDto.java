package json.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ProductSoldDto {

    @Expose
    private int count;
    @Expose
    private List<ProductInfoDto> productInfoDtos;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductInfoDto> getProductInfoDtos() {
        return productInfoDtos;
    }

    public void setProductInfoDtos(List<ProductInfoDto> productInfoDtos) {
        this.productInfoDtos = productInfoDtos;
    }
}
