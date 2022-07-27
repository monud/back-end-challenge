package com.skyflight.api.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.skyflight.domain.Article;
import com.skyflight.exception.DataFormatException;
import com.skyflight.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/")
@Api(tags = {"articles"})
public class ArticleController extends AbstractRestHandler {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles/",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a article resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createArticle(@RequestBody Article article,
                                 HttpServletRequest request, HttpServletResponse response) {
        Article createdArticle = this.articleService.createArticle(article);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdArticle.getId()).toString());
    }

    @RequestMapping(value = "/articles/",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all articles.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Article> getAllArticle(@ApiParam(value = "The page number (zero-based)", required = true)
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @ApiParam(value = "Tha page size", required = true)
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.articleService.getAllArticles(page, size);
    }

    @RequestMapping(value = "/articles/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single article.", notes = "You have to provide a valid article ID.")
    public
    @ResponseBody
    Article getArticle(@ApiParam(value = "The ID of the article.", required = true)
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        Article article = this.articleService.getArticle(id);
        checkResourceFound(article);
        //todo: http://goo.gl/6iNAkz
        return article;
    }

    @RequestMapping(value = "/articles/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a article resource.", notes = "You have to provide a valid article ID in the URL and in the payload. The ID attribute can not be updated.")
    public void updateArticle(@ApiParam(value = "The ID of the existing article resource.", required = true)
                                 @PathVariable("id") Long id, @RequestBody Article article,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.articleService.getArticle(id));
        if (id != article.getId()) throw new DataFormatException("ID doesn't match!");
        this.articleService.updateArticle(article);
    }

    //todo: @ApiImplicitParams, @ApiResponses
    @RequestMapping(value = "/articles/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a article resource.", notes = "You have to provide a valid article ID in the URL. Once deleted the resource can not be recovered.")
    public void deleteArticle(@ApiParam(value = "The ID of the existing article resource.", required = true)
                                 @PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.articleService.getArticle(id));
        this.articleService.deleteArticle(id);
    }
}
