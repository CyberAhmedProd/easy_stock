package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.VenteDto;
import java.util.List;

public interface VenteService {

    public VenteDto save(VenteDto venteDto);
    public VenteDto getVenteById(Integer idVente);
    public VenteDto getVenteByCode(String codeVente);
    public List<VenteDto> getAll();
    public void delete(Integer id);
}
