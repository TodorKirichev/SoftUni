package com.philately.service;

import com.philately.repository.PaperRepository;
import org.springframework.stereotype.Service;

@Service
public class PaperService {

    private final PaperRepository paperRepository;

    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }
}
