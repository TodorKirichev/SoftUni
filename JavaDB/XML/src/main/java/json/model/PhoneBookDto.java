package json.model;


import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneBookDto {

    private String owner;
    @XmlElementWrapper(name = "numbers")
    @XmlElement(name = "number")
    private List<String> numbers;
    @XmlElementWrapper
    @XmlElement(name = "phoneNumber")
    private List<PhoneNumberDto> phoneNumbers;

    public PhoneBookDto() {
    }

    public PhoneBookDto(String owner, List<String> numbers, List<PhoneNumberDto> phoneNumbers) {
        this.owner = owner;
        this.numbers = numbers;
        this.phoneNumbers = phoneNumbers;
    }
}
