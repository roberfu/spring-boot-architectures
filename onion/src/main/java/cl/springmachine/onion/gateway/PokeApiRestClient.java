package cl.springmachine.onion.gateway;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.springmachine.onion.domain.pokemon.Pokemon;
import cl.springmachine.onion.domain.service.PokeApiProvider;

@Component
public class PokeApiRestClient implements PokeApiProvider {

	private final RestTemplate restTemplate;

	public PokeApiRestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Pokemon getPokemon(String name) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + name;
		PokeApiPokemonDto pokeApiDto = restTemplate.getForObject(url, PokeApiPokemonDto.class);
		assert pokeApiDto != null;
		return Pokemon.builder().id(null).name(pokeApiDto.getName()).pokedexNumber(pokeApiDto.getId()).build();
	}

}
