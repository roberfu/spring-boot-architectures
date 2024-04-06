package cl.springmachine.custom.service.pokemon.impl;

import cl.springmachine.custom.client.pokeapi.PokeApiClient;
import cl.springmachine.custom.repository.PokemonRepository;
import cl.springmachine.custom.repository.model.PokemonEntity;
import cl.springmachine.custom.service.pokemon.PokemonService;
import cl.springmachine.custom.service.pokemon.dto.PokemonDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokeApiClient pokeApiClient;

    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokeApiClient pokeApiClient, PokemonRepository pokemonRepository) {
        this.pokeApiClient = pokeApiClient;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Integer savePokemon(String name) {
        PokemonDTO pokemonDto = pokeApiClient.getPokemonInfo(name);
        return pokemonRepository.save(PokemonEntity.builder()
                .type(pokemonDto.getType())
                .name(pokemonDto.getName())
                .pokedexNumber(pokemonDto.getPokedexNumber())
                .build()).getPokedexNumber();
    }

    @Override
    public PokemonDTO getPokemon(Integer pokedexNumber) {
        Optional<PokemonEntity> optional = pokemonRepository.findById(pokedexNumber);
        return optional.map(pokemonEntity -> PokemonDTO.builder()
                .pokedexNumber(pokemonEntity.getPokedexNumber())
                .name(pokemonEntity.getName())
                .type(pokemonEntity.getType())
                .build()).orElse(null);
    }

}
