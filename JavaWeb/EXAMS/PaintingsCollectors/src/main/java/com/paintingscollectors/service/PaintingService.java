package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.PaintingData;
import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.StyleName;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.repository.PaintingRepository;
import com.paintingscollectors.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class PaintingService {

    private final PaintingRepository paintingRepository;
    private final UserService userService;
    private final StyleService styleService;
    private final UserRepository userRepository;

    public PaintingService(PaintingRepository paintingRepository, UserService userService, StyleService styleService, UserRepository userRepository) {
        this.paintingRepository = paintingRepository;
        this.userService = userService;
        this.styleService = styleService;
        this.userRepository = userRepository;
    }

    public void addPainting(PaintingData paintingData, UUID id) {
        User userById = userService.findUserById(id);
        Style style = styleService.findByStyleName(StyleName.valueOf(paintingData.getStyle()));

        Painting painting = new Painting();
        painting.setName(paintingData.getName());
        painting.setAuthor(paintingData.getAuthor());
        painting.setImageUrl(paintingData.getImageUrl());
        painting.setStyle(style);
        painting.setOwner(userById);

//        TODO: add painting to user list and save user

        paintingRepository.save(painting);
    }

    public Set<Painting> findAllPaintingByOtherUsers(UUID currentUserId) {
        User userById = userService.findUserById(currentUserId);
        return paintingRepository.findAllByOwnerNot(userById);
    }

    public void removePainting(UUID id) {
        paintingRepository.deleteById(id);
    }

    public Painting getById(UUID id) {
        return paintingRepository.findById(id).orElse(null);
    }

    public void increaseVote(UUID id, UUID userId) {
        User userById = userService.findUserById(userId);
        Painting painting = userById.getRatedPaintings().stream().filter(p -> p.getId().equals(id)).findFirst().get();
        if (!userById.getRatedPaintings().contains(painting)) {
            painting.setVotes(painting.getVotes() + 1);
            userById.getRatedPaintings().add(painting);
            paintingRepository.save(painting);
            userRepository.save(userById);
        }
    }

    public List<Painting> getMostRatedPaintings() {
        return paintingRepository.getMostRatedPainting();
    }
}
