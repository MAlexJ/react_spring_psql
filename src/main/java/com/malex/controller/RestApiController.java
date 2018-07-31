package com.malex.controller;

import com.malex.dto.BuilderDTO;
import com.malex.enums.Gender;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import static com.malex.constant.Constant.LINK_ACTUAL;
import static com.malex.constant.Constant.SUCCESS_MESSAGE;

@RestController
@RequestMapping("/user")
public class RestApiController
{
    /**
     * GET: /user
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public BuilderDTO getAll()
    {
        return BuilderDTO.builder().message("List of users").build();
    }

    /**
     * GET: /user/{id}
     */
    @GetMapping(value = "{id}", produces = {MediaTypes.HAL_JSON_UTF8_VALUE})
    public BuilderDTO getById(@PathVariable("id") Long id, final HttpServletResponse response)
    {
        response.setHeader("Cache-Control", "no-cache");
        BuilderDTO dto = BuilderDTO.builder()
                .userId(id)
                .firstName("Maksymov")
                .lastName("Alex")
                .dataOfBirth(LocalDate.of(1985, 7, 21))
                .age(30)
                .gender(Gender.MALE)
                .message(SUCCESS_MESSAGE)
                .build();

        createHateoasLinks(dto);
        return dto;
    }

    /**
     * PUT: /user
     */
    @PutMapping
    public BuilderDTO insert()
    {
        return BuilderDTO.builder().message("getById").build();
    }

    /**
     * POST: /user/{id}
     */
    @PostMapping(value = "{id}")
    public BuilderDTO update(@PathVariable("id") Integer id)
    {
        return BuilderDTO.builder().message("put=" + id).build();
    }

    /**
     * DELETE: /user/{id}
     */
    @DeleteMapping(value = "{id}")
    public BuilderDTO delete(@PathVariable("id") Integer id)
    {
        return BuilderDTO.builder().message("delete=" + id).build();
    }

    /**
     * Create HATEOAS for REST
     */
    private void createHateoasLinks(final BuilderDTO dto)
    {
        dto.add(getLink(dto.getUserId(), "getById", "GET", "path: /user/{id}"),
                getLink(null, "getAll", "GET", "path: /user"),
                getLink(null, "insert", "PUT", "path: /user"),
                getLink(dto.getUserId(), "update", "POST", "path: /user/{id}"),
                getLink(dto.getUserId(), "delete", "DELETE", "path: /user/{id}"));
    }

    /**
     * Create link
     */
    private Link getLink(Object path, String rel, String method, String title)
    {
        return ControllerLinkBuilder.linkTo(this.getClass())
                .slash(path)
                .withRel(rel)
                .withTitle(title)
                .withDeprecation(LINK_ACTUAL)
                .withHreflang(method)
                .withMedia(MediaTypes.HAL_JSON_UTF8_VALUE)
                .withType(MediaType.APPLICATION_JSON.getSubtype());
    }
}
