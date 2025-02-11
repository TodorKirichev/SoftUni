package com.philately.service;

import com.philately.model.dto.StampData;
import com.philately.model.entity.Paper;
import com.philately.model.entity.Stamp;
import com.philately.model.entity.User;
import com.philately.repository.PaperRepository;
import com.philately.repository.StampRepository;
import com.philately.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StampService {

    private final StampRepository stampRepository;
    private final UserRepository userRepository;
    private final PaperRepository paperRepository;

    public StampService(StampRepository stampRepository, UserRepository userRepository, PaperRepository paperRepository) {
        this.stampRepository = stampRepository;
        this.userRepository = userRepository;
        this.paperRepository = paperRepository;
    }

    public void addStamp(StampData stampData, String userId) {
        Stamp stamp = new Stamp();
        User user = userRepository.findById(UUID.fromString(userId)).get();
        Paper paper = paperRepository.findByName(stampData.getPaperName());

        stamp.setName(stampData.getName());
        stamp.setDescription(stampData.getDescription());
        stamp.setImageURL(stampData.getImageURL());
        stamp.setPrice(stampData.getPrice());
        stamp.setOwner(user);
        stamp.setPaper(paper);

        stampRepository.save(stamp);

    }

    public List<Stamp> getStampsAddedByCurrentUser(User currentUser) {
        User user = userRepository.findById(currentUser.getId()).get();
        return stampRepository.findByOwner(user);
    }

    public List<Stamp> getAllStampsByOtherUsers(UUID currentUserId) {
        User user = userRepository.findById(currentUserId).get();

        return stampRepository.findAllByOwnerNot(user)
                .stream().filter(stamp -> !user.getWishedStamps().contains(stamp))
                .toList();
    }

    public Stamp findById(UUID id) {
        return stampRepository.findById(id).get();
    }
}
