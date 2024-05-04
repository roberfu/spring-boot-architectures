package cl.springmachine.onion.domain.service;

import org.springframework.stereotype.Component;

import cl.springmachine.onion.domain.pokemon.Pokemon;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PokemonService {

	private final ExternalPokeApiProvider pokeApiProvider;

	private final PokemonProvider pokemonProvider;

	public Integer createPokemon(String name) {
		Pokemon pokemon = pokeApiProvider.getPokemon(name);
		return pokemonProvider.createPokemon(pokemon);
	}

	public Pokemon readPokemon(Integer pokedexNumber) {
		return pokemonProvider.readPokemon(pokedexNumber);
	}

}
