package com.teamyostrik.easystock.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.teamyostrik.easystock.dto.ClientDto;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.services.ClientService;
import com.teamyostrik.easystock.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
@Service("clientStrategy")
@Slf4j
public class SaveClientImage implements Strategy<ClientDto> {
    @Autowired
    private FlickrService flickrService;
    @Autowired
    private ClientService clientService;
    @Override
    public ClientDto savePhoto(Integer id,InputStream photo, String title) throws FlickrException {

        ClientDto clientDto = clientService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo,title);
        if(!StringUtils.hasLength(urlPhoto))
        {
            throw new InvalideOperationException("Erreur lors de l'enregistrement de l'image du client", ErrorCode.UPDATE_PHOTO_EXCEPTION);
        }
        clientDto.setPhoto(urlPhoto);
        return clientService.save(clientDto);
    }
}
