package com.teamyostrik.easystock.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class StrategyPhotoContext {

    private BeanFactory beanFactory;
    private Strategy strategy;
    @Setter
    private String context;
    @Autowired
    public StrategyPhotoContext(BeanFactory beanFactory)
    {
        this.beanFactory = beanFactory;
    }
    public Object savePhoto(String context, Integer id, InputStream photo,String title) throws FlickrException {
        determineContext(context);
        return strategy.savePhoto(id,photo,title);
    }
    private void determineContext(String context)
    {
        final String beanName = context +"Strategy";
        switch (context)
        {
            case "article":
                strategy = beanFactory.getBean(beanName,SaveArticleImage.class);
                break;
            case "client":
                strategy = beanFactory.getBean(beanName,SaveClientImage.class);
                break;
            case "fornisseur":
                strategy = beanFactory.getBean(beanName,SaveFournisseurImage.class);
                break;
            case "entreprise":
                strategy = beanFactory.getBean(beanName,SaveFournisseurImage.class);
                break;
            case "utilisateur":
                strategy = beanFactory.getBean(beanName,SaveUtilisateurImage.class);
                break;
            default: throw new InvalideOperationException("Context inconnue", ErrorCode.BAD_CONTEXT);
        }
    }
}
