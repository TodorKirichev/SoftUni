package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaleImportDto {

    @Expose
    private boolean discounted;

    @NotNull
    @Size(min = 7, max = 7)
    @Expose
    private String number;

    @Expose
    private String saleDate;

    @Expose
    private Long seller;
}
