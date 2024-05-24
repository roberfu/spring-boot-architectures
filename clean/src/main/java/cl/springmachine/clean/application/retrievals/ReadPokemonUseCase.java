package cl.springmachine.clean.application.retrievals;

import cl.springmachine.clean.presenter.controller.PokemonDto;

public interface ReadPokemonUseCase {

	PokemonDto readPokemon(Integer pokedexNumber);

}
