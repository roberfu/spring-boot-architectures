package cl.springmachine.hexagonal.services;

import cl.springmachine.hexagonal.dtos.PokemonDto;

public interface PokemonService {

    Integer createPokemon(PokemonDto request);

    PokemonDto readPokemon(Integer id);

    void deletePokemon(Integer id);
}
