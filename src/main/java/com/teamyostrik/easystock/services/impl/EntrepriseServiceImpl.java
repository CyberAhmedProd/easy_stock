package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.EntrepriseDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.models.Entreprise;
import com.teamyostrik.easystock.repository.EntrepriseRepository;
import com.teamyostrik.easystock.services.EntrepriseService;
import com.teamyostrik.easystock.validators.EntrepriseValidator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty())
        {
            log.error("Entreprise is not valid {}", entrepriseDto);
            throw new EntityNotFoundExceptions("l'entrerise n'est pas valide" ,  ErrorCode.ENTREPRISE_NOT_FOUND);
        }
        return EntrepriseDto.fromEntity(
                entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto))
        );
    }
    @Override
    public EntrepriseDto findById(Integer id) {
        if(id == null)
        {
            log.error("Entreprise id is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucun entreprise avec l'id= "+ id
                        + " n'est été trouver dans la bd",
                        ErrorCode.ENTREPRISE_NOT_FOUND)
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return  entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Integer id) {


    }
}
