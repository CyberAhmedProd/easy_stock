package com.teamyostrik.easystock.controllers.api;

import com.flickr4java.flickr.FlickrException;
import com.teamyostrik.easystock.dto.MouvementSockDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Api(Constants.APP_ROOT + "photos")
public interface PhotoApi {

    @PostMapping(value = Constants.APP_ROOT+"photo/{id}/{title}/{context}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une image suivant un context",notes = "Cette methode permet d'enregistrer ou modifier une image", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet image cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    Object savePhoto(@PathVariable("context") String context, @PathVariable("id") Integer id, @RequestPart("file") MultipartFile photo, @PathVariable("title") String title) throws IOException, FlickrException;
}
