package json;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import json.model.AddressDto;
import json.model.PersonDto;
import json.model.PhoneBookDto;
import json.model.PhoneNumberDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        AddressDto addressDto = new AddressDto("Bg", "Pld");
        PersonDto personDto = new PersonDto("First", "last", 21, addressDto);
        JAXBContext personContext = JAXBContext.newInstance(PersonDto.class);
        Marshaller personMarshaller = personContext.createMarshaller();
        personMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        personMarshaller.marshal(personDto, System.out);

        Unmarshaller personUnmarshaller = personContext.createUnmarshaller();
        PersonDto parsedPerson = (PersonDto) personUnmarshaller.unmarshal(System.in);

        PhoneNumberDto phoneNumberDto = new PhoneNumberDto("123", "456");
        PhoneNumberDto phoneNumberDto2 = new PhoneNumberDto("123", "456");
        PhoneNumberDto phoneNumberDto3 = new PhoneNumberDto("123", "456");
        PhoneBookDto phoneBookDto = new PhoneBookDto("asd", List.of("asd", "qwe", "gvsdf "), List.of(phoneNumberDto, phoneNumberDto2, phoneNumberDto3));
        JAXBContext phoneBook = JAXBContext.newInstance(PhoneBookDto.class);
        Marshaller phoneBookMarshaller = phoneBook.createMarshaller();
        phoneBookMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        phoneBookMarshaller.marshal(phoneBookDto, System.out);
    }
}
