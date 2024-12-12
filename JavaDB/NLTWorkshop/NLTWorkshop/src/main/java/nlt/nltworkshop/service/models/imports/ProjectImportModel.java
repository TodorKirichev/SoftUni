package nlt.nltworkshop.service.models.imports;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JacksonXmlRootElement(localName = "project")
public class ProjectImportModel {

    @JacksonXmlProperty
    private String name;

    @JacksonXmlProperty
    private String description;

    @JacksonXmlProperty(localName = "start_date")
    private String startDate;

    @JacksonXmlProperty(localName = "is_finished")
    private boolean isFinished;

    @JacksonXmlProperty
    private BigDecimal payment;

    @JacksonXmlProperty(localName = "company")
    private CompanyImportModel companyName;
}
