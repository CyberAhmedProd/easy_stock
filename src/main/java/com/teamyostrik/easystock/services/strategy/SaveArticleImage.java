package com.teamyostrik.easystock.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.services.ArticleService;
import com.teamyostrik.easystock.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("articleStrategy")
@Slf4j
public class SaveArticleImage implements Strategy<ArticleDto>{
    @Autowired
    private FlickrService flickrService;
    @Autowired
    private ArticleService articleService;

    @Override
    public ArticleDto savePhoto(Integer id,InputStream photo, String title) throws FlickrException {
        ArticleDto articleDto = articleService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo,title);
        if(!StringUtils.hasLength(urlPhoto))
        {
            throw new InvalideOperationException("Erreur lors de l'enregistrement de la photo de l'article", ErrorCode.UPDATE_PHOTO_EXCEPTION);
        }
        articleDto.setPhoto(urlPhoto);

        return articleService.save(articleDto);
    }
}
