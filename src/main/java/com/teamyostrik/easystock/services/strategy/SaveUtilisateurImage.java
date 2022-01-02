package com.teamyostrik.easystock.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.teamyostrik.easystock.dto.UtilisateurDto;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.services.FlickrService;
import com.teamyostrik.easystock.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.io.InputStream;
@Service("utilisateurStrategy")
@Slf4j
public class SaveUtilisateurImage implements Strategy<UtilisateurDto> {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private FlickrService flickrService;
    @Override
    public UtilisateurDto savePhoto(Integer id, InputStream photo, String title) throws FlickrException {
        UtilisateurDto utilisateurDto = utilisateurService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo,title);
        if(!StringUtils.hasLength(urlPhoto))
        {
            throw new InvalideOperationException("Erreur lors de l'enregistrement de l'image de l'utiliseur", ErrorCode.UPDATE_PHOTO_EXCEPTION);
        }
        utilisateurDto.setPhoto(urlPhoto);
        return utilisateurService.save(utilisateurDto);
    }
}
