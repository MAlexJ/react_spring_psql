package com.malex.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

import static com.malex.constant.Constant.ERROR_HTML;

@Slf4j
@ControllerAdvice
public class ErrorController
{
    /**
     * Error page
     *
     * @return `error` page
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model)
    {
        log.error("Exception during execution of SpringSecurity application: ", throwable);
        String errorMessage = (Objects.isNull(throwable) ? "Unknown error" : throwable.getMessage());
        model.addAttribute("errorMessage", errorMessage);
        return ERROR_HTML;
    }
}