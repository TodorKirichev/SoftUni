package json.model;

import com.sun.xml.txw2.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberDto {

    private String name;
    private String number;

    public PhoneNumberDto(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public PhoneNumberDto() {
    }
}
