package cl.springmachine.layered.service;

import cl.springmachine.layered.dto.PokeApiPokemonDTO;

public interface PokeApiExternalService {

    PokeApiPokemonDTO getPokemonInfo(String name);
}
