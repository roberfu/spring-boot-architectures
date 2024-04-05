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
    public Integer save(PokemonDTO request) {
        PokemonDTO pokemonDto = pokeApiClient.getInfo(request.getName());
        return pokemonRepository.save(new PokemonEntity(null, pokemonDto.getName(), pokemonDto.getPokedexNumber()))
                .getId();
    }

    @Override
    public PokemonDTO get(Integer id) {
        Optional<PokemonEntity> optional = pokemonRepository.findById(id);
        return optional.map(pokemonEntity -> PokemonDTO.builder().id(pokemonEntity.getId())
                        .name(pokemonEntity.getName()).pokedexNumber(pokemonEntity.getPokedexNumber()).build())
                .orElse(null);
    }

    @Override
    public void delete(Integer id) {
        pokemonRepository.deleteById(id);
    }
}
