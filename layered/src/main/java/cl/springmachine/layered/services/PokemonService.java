package cl.springmachine.layered.services;

import cl.springmachine.layered.commons.dtos.PokemonDto;

public interface PokemonService {

    String createPokemon(String pokemonName);

    PokemonDto readPokemon(Integer pokemonId);

    void updatePokemon(Integer id, String pokemonName);

    void deletePokemon(Integer id);
}
