package exam.model.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class LaptopImportDto {

    @Expose
    @NotNull
    @Size(min = 8)
    private String macAddress;

    @Expose
    @NotNull
    @Positive
    private Double cpuSpeed;

    @Expose
    @NotNull
    @Min(value = 8)
    @Max(value = 128)
    private Integer ram;

    @Expose
    @NotNull
    @Min(value = 128)
    @Max(value = 1024)
    private Integer storage;

    @Expose
    @NotNull
    @Size(min = 10)
    private String description;

    @Expose
    @NotNull
    @Positive
    private Double price;

    @Expose
    @NotNull
    private String warrantyType;

    @Expose
    @NotNull
    private ShopDto shop;
}
