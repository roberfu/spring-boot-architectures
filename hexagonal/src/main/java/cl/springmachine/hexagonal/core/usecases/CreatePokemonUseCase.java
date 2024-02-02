package cl.springmachine.onion.core.usecases;

import cl.springmachine.onion.core.domain.pokemon.Pokemon;

public interface CreatePokemonUseCase {

    Integer createPokemon(Pokemon pokemon);
}
