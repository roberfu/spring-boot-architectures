package cl.springmachine.onion.services;

import cl.springmachine.onion.dtos.PokemonDto;

public interface PokemonService {

    Integer createPokemon(PokemonDto request);

    PokemonDto readPokemon(Integer id);

    void deletePokemon(Integer id);
}
