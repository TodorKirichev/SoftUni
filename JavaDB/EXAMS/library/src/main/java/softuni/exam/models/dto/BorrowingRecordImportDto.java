package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordImportDto {

    @NotNull
    @XmlElement(name = "borrow_date")
    private String borrowDate;

    @NotNull
    @XmlElement(name = "return_date")
    private String returnDate;

    @NotNull
    @XmlElement
    private BookDto book;

    @NotNull
    @XmlElement
    private LibraryMemberDto member;

    @Size(min = 3, max = 100)
    @XmlElement
    private String remarks;
}
