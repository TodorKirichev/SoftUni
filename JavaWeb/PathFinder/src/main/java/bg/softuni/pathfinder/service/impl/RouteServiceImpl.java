package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.dto.RouteInfoDto;
import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private Random random;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.random = new Random();
    }

    @Override
    public RouteInfoDto getRandomRoute() {
        long count = routeRepository.count();
        long randomNumber = random.nextLong(count) + 1;

        Route randomRoute = routeRepository.findById(randomNumber);
        RouteInfoDto routeInfoDto = modelMapper.map(randomRoute, RouteInfoDto.class);

        Picture picture = randomRoute.getPictures().stream().findFirst().get();

        routeInfoDto.setImageUrl(picture.getUrl());

        return routeInfoDto;
    }

    @Override
    public List<RouteInfoDto> getAllRoutes() {

        return routeRepository.findAll().stream()
                .map(this::mapToRouteInfoDto)
                .toList();
    }

    private RouteInfoDto mapToRouteInfoDto(Route route) {
        RouteInfoDto routeInfoDto = modelMapper.map(route, RouteInfoDto.class);
        routeInfoDto.setImageUrl(route.getPictures().stream().findFirst().get().getUrl());
        return routeInfoDto;
    }
}
