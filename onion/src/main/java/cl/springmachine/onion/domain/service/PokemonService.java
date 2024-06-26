package cl.springmachine.onion.domain.service;

import org.springframework.stereotype.Component;

import cl.springmachine.onion.domain.pokemon.Pokemon;
import cl.springmachine.onion.gateway.PokeApiPokemonDto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PokemonService {

	private final ExternalPokeApiProvider pokeApiProvider;

	private final PokemonProvider pokemonProvider;

	public Integer createPokemon(String name) {
		PokeApiPokemonDto pokeApiPokemonDto = pokeApiProvider.getPokemon(name);
		Pokemon pokemon = Pokemon.builder().name(pokeApiPokemonDto.getName()).pokedexNumber(pokeApiPokemonDto.getId())
				.type(pokeApiPokemonDto.getTypes().stream().findFirst()
						.map(pokemonType -> pokemonType.getType().getName()).orElseThrow())
				.build();
		return pokemonProvider.createPokemon(pokemon);
	}

	public Pokemon readPokemon(Integer pokedexNumber) {
		return pokemonProvider.readPokemon(pokedexNumber);
	}

}
