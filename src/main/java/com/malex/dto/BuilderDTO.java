package com.malex.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.malex.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuilderDTO extends ResourceSupport
{
    // model
    private Long userId;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataOfBirth;
    private Integer age;
    private Gender gender;

    // response
    private String message;
    private boolean isError;

    // default
    private String html;

    private List<BuilderDTO> users;

    public static class BuilderDTOBuilder
    {
        public BuilderDTOBuilder add(BuilderDTO dto)
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