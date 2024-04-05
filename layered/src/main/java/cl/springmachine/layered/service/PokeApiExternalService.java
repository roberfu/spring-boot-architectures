package cl.springmachine.layered.service;

import cl.springmachine.layered.dto.PokemonDTO;

public interface PokeApiExternalService {

    PokemonDTO getPokemonInfo(String name);
}
