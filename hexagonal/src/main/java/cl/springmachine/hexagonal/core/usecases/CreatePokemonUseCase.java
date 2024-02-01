package cl.springmachine.hexagonal.core.usecases;

import cl.springmachine.hexagonal.core.domain.pokemon.Pokemon;

public interface CreatePokemonUseCase {

    Integer createPokemon(Pokemon pokemon);
}
