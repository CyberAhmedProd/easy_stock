package com.teamyostrik.easystock.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.teamyostrik.easystock.dto.FournisseurDto;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.services.FlickrService;
import com.teamyostrik.easystock.services.FournisseurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
@Service("fournisseurStrategy")
@Slf4j
public class SaveFournisseurImage implements Strategy<FournisseurDto> {
    @Autowired
    private FournisseurService fournisseurService;
    @Autowired
    private FlickrService flickrService;
    @Override
    public FournisseurDto savePhoto(Integer id, InputStream photo, String title) throws FlickrException {
        FournisseurDto fournisseurDto = fournisseurService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo,title);
        if(!StringUtils.hasLength(urlPhoto))
        {
            throw new InvalideOperationException("Erreur lors de l'enregistrement de l'image du fournisseur", ErrorCode.UPDATE_PHOTO_EXCEPTION);
        }
        fournisseurDto.setPhoto(urlPhoto);
        return fournisseurService.save(fournisseurDto);
    }
}
