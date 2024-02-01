package cl.springmachine.hexagonal.services;

import cl.springmachine.hexagonal.dtos.PokemonDto;

public interface PokeApiService {

    PokemonDto getPokemonInfo(String name);
}
