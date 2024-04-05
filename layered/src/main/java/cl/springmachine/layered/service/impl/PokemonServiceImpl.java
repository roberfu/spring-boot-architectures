package cl.springmachine.layered.service.impl;

import cl.springmachine.layered.dto.PokemonDTO;
import cl.springmachine.layered.entity.PokemonEntity;
import cl.springmachine.layered.repository.PokemonRepository;
import cl.springmachine.layered.service.PokeApiExternalService;
import cl.springmachine.layered.service.PokemonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    private final PokeApiExternalService pokeApiService;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, PokeApiExternalService pokeApiService) {
        this.pokemonRepository = pokemonRepository;
        this.pokeApiService = pokeApiService;
    }

    @Override
    @Transactional
    public Integer savePokemon(String name) {
        PokemonDTO pokemonDTO = pokeApiService.getPokemonInfo(name);
        return pokemonRepository.save(PokemonEntity.builder()
                .type(pokemonDTO.getType())
                .name(pokemonDTO.getName())
                .pokedexNumber(pokemonDTO.getPokedexNumber())
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
