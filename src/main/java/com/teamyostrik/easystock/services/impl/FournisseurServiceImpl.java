package com.teamyostrik.easystock.services.impl;


import com.teamyostrik.easystock.dto.FournisseurDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.models.Fournisseur;
import com.teamyostrik.easystock.repository.FournisseurRepository;
import com.teamyostrik.easystock.services.FournisseurService;
import com.teamyostrik.easystock.validators.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validate(fournisseurDto);
        if(!errors.isEmpty())
        {
            log.error("Fournisseur is not valid {}", fournisseurDto);
            throw new EntityNotFoundExceptions("le fourniisseur n'est pas valide" ,  ErrorCode.FOURNISSEUR_NOT_FOUND );
        }
        return fournisseurDto.fromEntity(
                fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto))
        );
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if(id == null)
        {
            log.error("Fournisseur id is null");
            return null;
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucun Fournisseur avec l'id= "+ id
                        + " n'est été trouver dans la bd",
                        ErrorCode.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return  fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Fournisseur ID is null");
            return;
        }
        fournisseurRepository.deleteById(id);
    }
}
