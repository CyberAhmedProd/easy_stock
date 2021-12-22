package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.VenteDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.models.Article;
import com.teamyostrik.easystock.repository.ArticleRepository;
import com.teamyostrik.easystock.repository.LigneVenteRepository;
import com.teamyostrik.easystock.repository.VenteRepository;
import com.teamyostrik.easystock.services.VenteService;
import com.teamyostrik.easystock.validators.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

        venteDto.getLigneVenteDtos().forEach(ligneVente -> {
            Optional<Article> article = articleRepository.getById(ligneVente.get)
        });

        return null;
    }

    @Override
    public VenteDto getVenteById(Integer idVente) {
        return null;
    }

    @Override
    public VenteDto getVenteByCode(String codeVente) {
        return null;
    }

    @Override
    public List<VenteDto> getAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
