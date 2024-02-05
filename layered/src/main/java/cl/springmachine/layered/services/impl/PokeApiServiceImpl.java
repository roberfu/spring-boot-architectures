package cl.springmachine.layered.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.springmachine.layered.dtos.PokeApiPokemonDto;
import cl.springmachine.layered.dtos.PokemonDto;
import cl.springmachine.layered.services.PokeApiService;

@Service
public class PokeApiServiceImpl implements PokeApiService {

	private final RestTemplate restTemplate;

	public PokeApiServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public PokemonDto getPokemonInfo(String name) {

		String url = "https://pokeapi.co/api/v2/pokemon/" + name;
		PokeApiPokemonDto pokeApiPokemonDto = restTemplate.getForObject(url, PokeApiPokemonDto.class);
		assert pokeApiPokemonDto != null;
		return PokemonDto.builder().name(pokeApiPokemonDto.getName()).pokedexNumber(pokeApiPokemonDto.getId()).build();
	}
}
