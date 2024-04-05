package cl.springmachine.custom.service.pokemon;

import cl.springmachine.custom.service.pokemon.dto.PokemonDTO;

public interface PokemonService {

    Integer save(PokemonDTO request);

    PokemonDTO get(Integer id);

    void delete(Integer id);
}
