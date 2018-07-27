package com.malex.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@ToString
public class BuilderDTO
{
    // response
    private String message;
    boolean isError;

    // default
    private String html;

    // Category
    private Integer idCategory;
    private String nameCategory;
    private String descriptionCategory;
    private String htmlCategory;

    private List<BuilderDTO> subCategories;

    public static class BuilderDTOBuilder
    {
        BuilderDTOBuilder addSubCategory(BuilderDTO dto)
        {
            if (Objects.isNull(subCategories))
            {
                subCategories = new ArrayList<>();
            }
            subCategories.add(dto);
            return this;
        }
    }
}