package cl.springmachine.onion.domain.service;

import cl.springmachine.onion.domain.pokemon.Pokemon;

public interface PokemonProvider {

	Integer createPokemon(Pokemon pokemon);

	Pokemon readPokemon(Integer pokedexNumber);

}