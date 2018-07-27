package com.malex.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.malex.constant.Constant.INDEX_HTML;

@Slf4j
@Controller
public class PageViewController
{
    /**
     * Processing of the main `index.html` page
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET, produces = "text/html")
    public String homePage()
    {
        return INDEX_HTML;
    }

    /**
     * Processing page refresh
     */
    @RequestMapping(value = "/{page}", method = RequestMethod.GET, produces = "text/html")
    public String page(@PathVariable("page") String page)
    {
        log.debug(" >>> page: " + page);
        return INDEX_HTML;
    }
}