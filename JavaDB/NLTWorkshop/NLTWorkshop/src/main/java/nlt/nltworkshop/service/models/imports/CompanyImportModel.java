package nlt.nltworkshop.service.models.imports;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompanyImportModel {

    @JacksonXmlProperty(isAttribute = true)
    private String name;
}
