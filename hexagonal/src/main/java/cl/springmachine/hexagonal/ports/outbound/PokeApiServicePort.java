package cl.springmachine.hexagonal.ports.outbound;

import cl.springmachine.hexagonal.ports.inbound.PokemonDto;

public interface PokeApiServicePort {
    PokemonDto getPokemonInfoPokeApi(String name);
}
