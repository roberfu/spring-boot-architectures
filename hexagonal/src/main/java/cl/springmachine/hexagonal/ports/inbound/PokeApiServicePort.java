package cl.springmachine.hexagonal.ports.inbound;

public interface PokeApiServicePort {
    PokemonDto getPokemonPokeApi(String name);
}
