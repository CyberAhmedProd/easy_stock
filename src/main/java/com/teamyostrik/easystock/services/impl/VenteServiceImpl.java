package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.*;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.models.*;
import com.teamyostrik.easystock.repository.ArticleRepository;
import com.teamyostrik.easystock.repository.LigneVenteRepository;
import com.teamyostrik.easystock.repository.VenteRepository;
import com.teamyostrik.easystock.services.VenteService;
import com.teamyostrik.easystock.validators.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private VenteRepository venteRepository;
    @Autowired
    private LigneVenteRepository ligneVenteRepository;

    @Override
    public VenteDto save(VenteDto venteDto) {
        List<String> errors = VenteValidator.validate(venteDto);
        if(!errors.isEmpty())
        {
            log.error("Vente n'est pas valide");
            throw new EntityNotFoundExceptions("La vente n'est pas valide",
                    ErrorCode.VENTE_NOT_FOUND);
        }
        List<String> articleErrors = new ArrayList<>();
        if(venteDto.getLigneVenteDtos() != null)
        {
            venteDto.getLigneVenteDtos().forEach(ligneVente -> {
                if(ligneVente.getArticle() != null)
                {
                    Optional<Article> article = articleRepository.findById(ligneVente.getArticle().getId());
                    if(!article.isPresent())
                    {
                        articleErrors.add("L'article avec l'ID "+ligneVente.getArticle().getId()+" n'exsite pas");
                    }
                }
                else
                {
                    articleErrors.add("impossible d'enregister une vente avec sans article");
                }
            });
        }

        if(!articleErrors.isEmpty())
        {
            log.warn("Article non existant");
            throw new EntityNotFoundExceptions("Article n'exite pas dans la BD"
                    ,ErrorCode.ARTICLE_NOT_FOUND);
        }

        Vente savedVente =  venteRepository.save(venteDto.toEntity(venteDto));
        if(venteDto.getLigneVenteDtos() != null)
        {
            venteDto.getLigneVenteDtos().forEach(ligneVente -> {
                LigneVente ligne = LigneVenteDto.toEntity(ligneVente);
                ligne.setVente(savedVente);
                ligneVenteRepository.save(ligne);
            });
        }

        return VenteDto.fromEntity(savedVente);
    }

    @Override
    public VenteDto getVenteById(Integer idVente) {
        if(idVente == null)
        {
            log.error("Vente avec ID null");
            return null;
        }
        return venteRepository.findById(idVente)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundExceptions(
                        "Aucune Vente n'a ete trouve avec l'ID "+idVente,
                        ErrorCode.VENTE_NOT_FOUND
                ));
    }

    @Override
    public VenteDto getVenteByCode(String codeVente) {
        if(!StringUtils.hasLength(codeVente))
        {
            log.error("Vente avec Code NULL");
            return null;
        }
        return venteRepository.findVenteByCode(codeVente)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundExceptions(
                        "Aucune Vente n'a ete trouve avec le Code Vente "+codeVente,
                        ErrorCode.VENTE_NOT_FOUND
                ));
    }

    @Override
    public List<VenteDto> getAll() {
        return venteRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Vente ID is NULL");
            return;
        }
        venteRepository.deleteById(id);
    }
}
