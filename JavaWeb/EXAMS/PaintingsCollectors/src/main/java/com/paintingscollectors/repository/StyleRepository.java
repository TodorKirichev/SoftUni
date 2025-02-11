package com.paintingscollectors.repository;

import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.StyleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StyleRepository extends JpaRepository<Style, UUID> {
    Style findByName(StyleName style);
}
