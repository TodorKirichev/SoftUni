package nlt.nltworkshop.service.models.imports;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JacksonXmlRootElement(localName = "projects")
public class ProjectRootImportModel {

    @JacksonXmlProperty(localName = "project")
    private Set<ProjectImportModel> projects;
}
