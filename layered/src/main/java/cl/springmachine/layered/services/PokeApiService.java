package cl.springmachine.onion.services;

import cl.springmachine.onion.dtos.PokemonDto;

public interface PokeApiService {

    PokemonDto getPokemonInfo(String name);
}
