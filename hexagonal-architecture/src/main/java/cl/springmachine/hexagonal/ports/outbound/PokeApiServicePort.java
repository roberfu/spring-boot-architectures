package cl.springmachine.hexagonal.ports.outbound;

import cl.springmachine.hexagonal.adapters.outbound.PokeApiPokemonDto;

public interface PokeApiServicePort {
    PokeApiPokemonDto getPokemonInfoPokeApi(String name);
}
