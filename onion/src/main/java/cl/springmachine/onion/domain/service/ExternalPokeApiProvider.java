package cl.springmachine.onion.domain.service;

import cl.springmachine.onion.domain.pokemon.Pokemon;

public interface ExternalPokeApiProvider {

	Pokemon getPokemon(String name);

}
