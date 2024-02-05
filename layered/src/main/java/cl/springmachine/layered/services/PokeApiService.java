package cl.springmachine.layered.services;

import cl.springmachine.layered.dtos.PokemonDto;

public interface PokeApiService {

	PokemonDto getPokemonInfo(String name);
}
