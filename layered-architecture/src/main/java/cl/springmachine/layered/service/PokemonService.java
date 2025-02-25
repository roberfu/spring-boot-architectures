package cl.springmachine.layered.service;

import cl.springmachine.layered.dto.PokemonDTO;

public interface PokemonService {

    Integer savePokemon(String name);

    PokemonDTO getPokemon(Integer pokedexNumber);

}
