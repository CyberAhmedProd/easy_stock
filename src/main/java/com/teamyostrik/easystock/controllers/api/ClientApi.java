package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.ClientDto;
import com.teamyostrik.easystock.utils.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientApi {
    @PostMapping(value = Constants.APP_ROOT+"client/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto create(@RequestBody ClientDto client);
    @GetMapping(value = Constants.APP_ROOT+"client/{id_client}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto getById(@PathVariable("id_client") Integer id);
    @GetMapping(value = Constants.APP_ROOT+"client/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDto> getAll();
    @DeleteMapping(value = Constants.APP_ROOT+"client/delete/{id_client}")
    public void delete(@PathVariable("id_client") Integer idClient);
}
