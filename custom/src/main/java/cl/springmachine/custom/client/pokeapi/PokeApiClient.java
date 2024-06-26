package cl.springmachine.custom.client.pokeapi;

import cl.springmachine.custom.client.pokeapi.dto.PokemonPokeApiDTO;

public interface PokeApiClient {

    PokemonPokeApiDTO getPokemonInfo(String name);
}
