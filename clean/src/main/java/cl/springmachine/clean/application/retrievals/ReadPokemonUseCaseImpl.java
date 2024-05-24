package cl.springmachine.clean.application.retrievals;

import org.springframework.stereotype.Component;

import cl.springmachine.clean.domain.model.Pokemon;
import cl.springmachine.clean.domain.repository.PokemonRepository;
import cl.springmachine.clean.presenter.controller.PokemonDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ReadPokemonUseCaseImpl implements ReadPokemonUseCase {

	private final PokemonRepository pokemonRepository;

	@Override
	public PokemonDto readPokemon(Integer pokedexNumber) {
		Pokemon pokemon = pokemonRepository.findByPokedexNumber(pokedexNumber);
		return PokemonDto.builder().name(pokemon.getName()).type(pokemon.getType())
				.pokedexNumber(pokemon.getPokedexNumber()).build();
	}

}
