package com.philately.repository;

import com.philately.model.entity.Paper;
import com.philately.model.entity.PaperName;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaperRepository extends JpaRepository<Paper, UUID> {
    Paper findByName(PaperName paperName);
}
