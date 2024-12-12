package nlt.nltworkshop.web.controllers;

import nlt.nltworkshop.service.CompanyService;
import nlt.nltworkshop.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController {

    private final CompanyService companyService;
    private final ProjectService projectService;

    @Autowired
    public ImportController(CompanyService companyService, ProjectService projectService) {
        this.companyService = companyService;
        this.projectService = projectService;
    }

    @GetMapping("/xml")
    public ModelAndView xml() {
        ModelAndView mav = new ModelAndView("xml/import-xml");
        mav.addObject("areImported", new boolean[]{companyService.isImported(), projectService.isImported(), false});

        return mav;
    }

    @GetMapping("/companies")
    public ModelAndView companies() throws IOException {
        ModelAndView mav = new ModelAndView("xml/import-companies");
        mav.addObject("companies", companyService.readFile());

        return mav;
    }

    @PostMapping("/companies")
    public ModelAndView companiesPost() throws JAXBException, FileNotFoundException {
        ModelAndView mav = new ModelAndView("redirect:xml");
        companyService.seedData();
        return mav;
    }


    @GetMapping("/projects")
    public ModelAndView projects() throws IOException {
        ModelAndView mav = new ModelAndView("xml/import-projects");
        mav.addObject("projects", projectService.readFile());

        return mav;
    }

    @PostMapping("/projects")
    public ModelAndView projectsPost() throws JAXBException, FileNotFoundException {
        ModelAndView mav = new ModelAndView("redirect:xml");
        projectService.seedData();

        return mav;
    }

    @GetMapping("/employees")
    public ModelAndView employees() {
        ModelAndView mav = new ModelAndView("xml/import-employees");
        mav.addObject("employees", "");

        return mav;
    }
}
