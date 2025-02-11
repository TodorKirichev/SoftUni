package com.resellerapp.service;

import com.resellerapp.config.UserSession;
import com.resellerapp.model.dto.OfferData;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.ConditionName;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;

    public OfferService(OfferRepository offerRepository, ConditionRepository conditionRepository, UserRepository userRepository, UserSession userSession) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public void addOffer(OfferData offerData) {
        Offer offer = new Offer();
        offer.setDescription(offerData.getDescription());
        offer.setPrice(BigDecimal.valueOf(offerData.getPrice()));
        Condition condition = conditionRepository.findByName(offerData.getCondition());
        offer.setCondition(condition);
        User user = userRepository.findById(userSession.getId()).get();
        offer.setCreatedBy(user);
        offerRepository.save(offer);
    }

    public List<Offer> getAllOffers() {
        User user = userRepository.findById(userSession.getId()).get();
        return offerRepository.findAll().stream()
                .filter(offer -> !offer.getCreatedBy().getUsername().equals(user.getUsername()))
                .filter(offer ->offer.getBoughtBy() == null || !offer.getBoughtBy().getUsername().equals(user.getUsername()))
                .toList();
    }

    public void buyOffer(UUID id) {
        Offer offer = offerRepository.findById(id).get();
        User user = userRepository.findById(userSession.getId()).get();
        offer.setBoughtBy(user);
        offerRepository.save(offer);
    }

    public List<Offer> getLoggedInUserBoughtOffers(UUID id) {
        User user = userRepository.findById(id).get();
        return offerRepository.findAllByBoughtBy(user);
    }

    public void removeOffer(UUID id) {
        offerRepository.deleteById(id);
    }
}
