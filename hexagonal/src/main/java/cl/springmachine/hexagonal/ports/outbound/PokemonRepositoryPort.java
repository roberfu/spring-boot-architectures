package cl.springmachine.onion.ports.outbound;

import cl.springmachine.onion.core.domain.pokemon.Pokemon;

public interface PokemonRepositoryPort {

    Integer savePokemon(Pokemon pokemon);

    Pokemon getPokemon(Integer id);

    void deletePokemon(Integer id);

}
