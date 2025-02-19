package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.dto.RouteInfoDto;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {
//        RouteInfoDto randomRoute = routeService.getRandomRoute();
//        model.addAttribute("route", randomRoute);

        List<RouteInfoDto> routes = routeService.getAllRoutes();
        model.addAttribute("routes", routes);

        return "routes";
    }
}
