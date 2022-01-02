package com.teamyostrik.easystock.controllers;

import com.flickr4java.flickr.FlickrException;
import com.teamyostrik.easystock.controllers.api.PhotoApi;
import com.teamyostrik.easystock.services.strategy.StrategyPhotoContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ImageController implements PhotoApi {
    @Autowired
    private StrategyPhotoContext strategyPhotoContext;
    @Override
    public Object savePhoto(String context, Integer id, MultipartFile photo, String title) throws IOException, FlickrException {
        return strategyPhotoContext.savePhoto(context,id,photo.getInputStream(),title);
    }
}
