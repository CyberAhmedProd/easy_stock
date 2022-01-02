package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.MouvementSockDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalidEntityExceptions;
import com.teamyostrik.easystock.models.*;
import com.teamyostrik.easystock.repository.ArticleRepository;
import com.teamyostrik.easystock.repository.MouvementStockRepository;
import com.teamyostrik.easystock.services.MouvementStockService;
import com.teamyostrik.easystock.validators.MouvementStockValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MouvementStockServiceImpl implements MouvementStockService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private MouvementStockRepository mouvementStockRepository;

    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {
        if(idArticle == null)
        {
            log.warn("ID Article is NULL");
            return BigDecimal.valueOf(-1);
        }
        articleRepository.findById(idArticle);
        return mouvementStockRepository.stockReelArticle(idArticle);
    }

    @Override
    public List<MouvementSockDto> mvtStockArticle(Integer idArticle) {
        return  mouvementStockRepository.findAllByArticleId(idArticle).stream()
                .map(MouvementSockDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MouvementSockDto entreStock(MouvementSockDto mouvementSockDto) {
       return entrePositive(mouvementSockDto,TypeMouvement.ENTREE);
    }

    @Override
    public MouvementSockDto sortieStock(MouvementSockDto mouvementSockDto) {
      return sortieNegatif(mouvementSockDto,TypeMouvement.SORTIE);
    }

    @Override
    public MouvementSockDto correctionStockPositif(MouvementSockDto mouvementSockDto) {
        return entrePositive(mouvementSockDto,TypeMouvement.CORRECTION_POS);
    }

    @Override
    public MouvementSockDto correctionStockNegatif(MouvementSockDto mouvementSockDto) {
       return sortieNegatif(mouvementSockDto,TypeMouvement.CORRECTION_NEG);
    }

    @Override
    public MouvementSockDto save(MouvementSockDto mouvementSockDto) {
        List<String> errors = MouvementStockValidator.validate(mouvementSockDto);
        if(!errors.isEmpty())
        {
            log.error("Mouvement Stock n'est pas valide");
            throw new EntityNotFoundExceptions("Le Mouvement de Stock n'est pas valide",
                    ErrorCode.MOUVEMENT_STOCK_NOT_FOUND);
        }
        Optional<Article> article = articleRepository.findById(mouvementSockDto.getArticle().getId());
        if(!article.isPresent())
        {
            log.warn("Article with ID {} is not found in DB",mouvementSockDto.getArticle().getId());
            throw new EntityNotFoundExceptions("Aucun Article avec l'id "+mouvementSockDto.getArticle().getId()+
                    " n'est trouve dans le BD"
                    ,ErrorCode.ARTICLE_NOT_FOUND);
        }

        // a revoir  !!!
        return MouvementSockDto.fromEntity(mouvementStockRepository.save(MouvementSockDto.toEntity(mouvementSockDto)));
    }

    @Override
    public MouvementSockDto findById(Integer id) {
        if(id == null)
        {
            log.error("Mouvement Stock ID is null");
            return null;
        }
        Optional<MouvementSock> mouvementSock = mouvementStockRepository.findById(id);
        return Optional.of(MouvementSockDto.fromEntity(mouvementSock.get())).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucun Mouvement de stock avec l'id= "+ id
                        + " n'est été trouver dans la bd",
                        ErrorCode.MOUVEMENT_STOCK_NOT_FOUND)
        );
    }

    @Override
    public List<MouvementSockDto> findAll() {
        return  mouvementStockRepository.findAll().stream()
                .map(MouvementSockDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Mouvement Stock ID is NULL");
            return;
        }

        mouvementStockRepository.deleteById(id);

    }

    private MouvementSockDto entrePositive(MouvementSockDto mouvementSockDto,TypeMouvement typeMouvement){

        List<String> errors = MouvementStockValidator.validate(mouvementSockDto);
        if(!errors.isEmpty())
        {
            log.error("Mouvement is not valid {}", mouvementSockDto);
            throw new InvalidEntityExceptions("le Mouvement n'est pas valide",ErrorCode.MOUVEMENT_STOCK_NOT_VALID);
        }
        mouvementSockDto.setTypeMouvement(typeMouvement);
        mouvementSockDto.setQuantite(Math.abs(mouvementSockDto.getQuantite()));
        return MouvementSockDto.fromEntity(mouvementStockRepository.save(MouvementSockDto.toEntity(mouvementSockDto)));
    }
    private MouvementSockDto sortieNegatif(MouvementSockDto mouvementSockDto,TypeMouvement typeMouvement){

        List<String> errors = MouvementStockValidator.validate(mouvementSockDto);
        if(!errors.isEmpty())
        {
            log.error("Mouvement is not valid {}", mouvementSockDto);
            throw new InvalidEntityExceptions("le Mouvement n'est pas valide",ErrorCode.MOUVEMENT_STOCK_NOT_VALID);
        }
        mouvementSockDto.setTypeMouvement(typeMouvement);
        mouvementSockDto.setQuantite(Math.abs(mouvementSockDto.getQuantite()) * -1);
        return MouvementSockDto.fromEntity(mouvementStockRepository.save(MouvementSockDto.toEntity(mouvementSockDto)));
    }
}
