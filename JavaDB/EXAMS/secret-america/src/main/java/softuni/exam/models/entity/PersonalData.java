package softuni.exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "personal_datas")
public class PersonalData extends BaseEntity {

    @Column
    private Integer age;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "card_number", unique = true, nullable = false)
    private String cardNumber;

    @Column
    private String gender;


}
