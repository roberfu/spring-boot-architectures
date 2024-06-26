package cl.springmachine.onion.domain.service;

import cl.springmachine.onion.gateway.PokeApiPokemonDto;

public interface ExternalPokeApiProvider {

	PokeApiPokemonDto getPokemon(String name);

}
