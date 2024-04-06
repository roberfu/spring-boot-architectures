package cl.springmachine.custom.service.pokemon;

import cl.springmachine.custom.service.pokemon.dto.PokemonDTO;

public interface PokemonService {

    Integer savePokemon(String name);

    PokemonDTO getPokemon(Integer pokedexNumber);

}
