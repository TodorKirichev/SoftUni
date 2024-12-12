package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.dto.RouteInfoDto;

import java.util.List;

public interface RouteService {

    RouteInfoDto getRandomRoute();

    List<RouteInfoDto> getAllRoutes();
}
