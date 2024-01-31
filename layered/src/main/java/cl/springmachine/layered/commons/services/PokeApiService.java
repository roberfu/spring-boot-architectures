package cl.springmachine.layered.commons.services;

import cl.springmachine.layered.commons.dtos.PokemonDto;

public interface PokeApiService {
    
    PokemonDto getPokemonInfo(String pokemonName);
}
