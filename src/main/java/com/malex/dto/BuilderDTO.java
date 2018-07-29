package com.malex.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuilderDTO
{
    // model
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate dataOfBirth;
    private Integer age;
    private String gender;

    // response
    private String message;
    private boolean isError;

    // default
    private String html;

    private List<BuilderDTO> users;

    public static class BuilderDTOBuilder
    {
        BuilderDTOBuilder addSubCategory(BuilderDTO dto)
        {
            if (Objects.isNull(users))
            {
                users = new ArrayList<>();
            }
            users.add(dto);
            return this;
        }
    }
}