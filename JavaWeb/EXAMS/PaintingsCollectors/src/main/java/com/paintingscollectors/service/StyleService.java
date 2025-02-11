package com.paintingscollectors.service;

import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.StyleName;
import com.paintingscollectors.repository.StyleRepository;
import org.springframework.stereotype.Service;

@Service
public class StyleService {

    private final StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public Style findByStyleName(StyleName style) {
        return styleRepository.findByName(style);
    }
}
