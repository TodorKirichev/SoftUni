package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.AddOfferDto;
import bg.softuni.mobilele.model.entity.OfferEntity;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void createOrder(AddOfferDto addOfferDto) {
        offerRepository.save(mapToOfferEntity(addOfferDto));
    }

    private static OfferEntity mapToOfferEntity(AddOfferDto addOfferDto) {
        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setEngine(addOfferDto.engineTypeEnum());
        offerEntity.setDescription(addOfferDto.description());
        return offerEntity;
    }
}
