package cl.springmachine.hexagonal.core.usecases;

import cl.springmachine.hexagonal.core.domain.pokemon.Pokemon;

public interface ReadPokemonUseCase {

    Pokemon readPokemon(Integer id);
}
