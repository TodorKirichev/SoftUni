package com.paintingscollectors.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaintingData {

    @NotBlank
    @Size(min = 5, max = 40)
    private String name;

    @NotBlank
    @Size(min = 5, max = 30)
    private String author;

    @NotBlank
    @Size(max = 150)
    private String imageUrl;

    @NotBlank
    private String style;
}
