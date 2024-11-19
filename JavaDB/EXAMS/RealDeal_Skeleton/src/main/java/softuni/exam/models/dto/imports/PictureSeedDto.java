package softuni.exam.models.dto.imports;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class PictureSeedDto {

    @Expose
    private String name;
    @Expose
    private String dateAndTime;
    @Expose
    private Long car;

    @Size(min = 2, max = 19)
    @Column(unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Column
    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public PictureSeedDto() {
    }
}
