package cl.springmachine.layered.services.impl;

import cl.springmachine.layered.commons.dtos.PokemonDto;
import cl.springmachine.layered.commons.services.PokeApiService;
import cl.springmachine.layered.entities.PokemonEntity;
import cl.springmachine.layered.repositories.PokemonRepository;
import cl.springmachine.layered.services.PokemonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    private final PokeApiService pokeApiService;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, PokeApiService pokeApiService) {
        this.pokemonRepository = pokemonRepository;
        this.pokeApiService = pokeApiService;
    }

    @Override
    @Transactional
    public String createPokemon(String pokemonName) {
        PokemonDto pokemonDto = pokeApiService.getPokemonInfo(pokemonName);
        Integer id = pokemonRepository.save(new PokemonEntity(null, pokemonDto.getName(), pokemonDto.getPokedexNumber())).getId();
        return id.toString();
    }

    @Override
    public PokemonDto readPokemon(Integer pokemonId) {
        Optional<PokemonEntity> optional = pokemonRepository.findById(pokemonId);
        return optional.map(pokemonEntity -> PokemonDto.builder()
                .id(pokemonEntity.getId())
                .name(pokemonEntity.getName())
                .pokedexNumber(pokemonEntity.getPokedexNumber())
                .build()).orElse(null);
    }

    @Override
    @Transactional
    public void updatePokemon(Integer id, String pokemonName) {
        PokemonDto pokemonDto = pokeApiService.getPokemonInfo(pokemonName);
        Optional<PokemonEntity> optional = pokemonRepository.findById(id);
        if (optional.isPresent()) {
            PokemonEntity pokemonEntity = optional.get();
            pokemonEntity.setName(pokemonDto.getName());
            pokemonEntity.setPokedexNumber(pokemonDto.getPokedexNumber());
            pokemonRepository.save(pokemonEntity);
        }
    }

    @Override
    @Transactional
    public void deletePokemon(Integer id) {
        pokemonRepository.deleteById(id);
    }
}
