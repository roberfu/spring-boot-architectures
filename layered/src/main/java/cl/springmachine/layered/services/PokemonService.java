package cl.springmachine.layered.services;

import cl.springmachine.layered.dtos.PokemonDto;

public interface PokemonService {

	Integer createPokemon(PokemonDto request);

	PokemonDto readPokemon(Integer id);

	void deletePokemon(Integer id);
}
