package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.CategorieDto;
import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Api(Constants.APP_ROOT + "commande_clients")
public interface CommandeClientApi {
    @PostMapping(value = Constants.APP_ROOT+"commande_client",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une commande client",notes = "Cette methode permet d'enregistrer ou modifier une commande client", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet commande client cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    CommandeClientDto save(CommandeClientDto commandeClientDto);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCodeCommande(String codeCommandeClient);
    List<CommandeClientDto> findAll();
    void delete(Integer id);
}
