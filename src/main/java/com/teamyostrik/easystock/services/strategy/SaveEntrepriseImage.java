package com.teamyostrik.easystock.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.teamyostrik.easystock.dto.EntrepriseDto;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.services.EntrepriseService;
import com.teamyostrik.easystock.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
@Service("entrepriseStrategy")
@Slf4j
public class SaveEntrepriseImage implements Strategy<EntrepriseDto> {
    @Autowired
    private FlickrService flickrService;
    @Autowired
    private EntrepriseService entrepriseService;
    @Override
    public EntrepriseDto savePhoto(Integer id, InputStream photo, String title) throws FlickrException {
        EntrepriseDto entrepriseDto = entrepriseService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo,title);
        if(!StringUtils.hasLength(urlPhoto))
        {
            throw new InvalideOperationException("Erreur lors de l'enregistrement de l'image de l'entrepirse", ErrorCode.UPDATE_PHOTO_EXCEPTION);
        }
        entrepriseDto.setPhoto(urlPhoto);
        return entrepriseService.save(entrepriseDto);
    }
}
