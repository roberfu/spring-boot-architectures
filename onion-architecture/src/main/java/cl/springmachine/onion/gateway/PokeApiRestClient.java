package cl.springmachine.onion.gateway;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.springmachine.onion.domain.service.ExternalPokeApiProvider;

@Component
public class PokeApiRestClient implements ExternalPokeApiProvider {

	private final RestTemplate restTemplate;

	public PokeApiRestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public PokeApiPokemonDto getPokemon(String name) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + name;
		PokeApiPokemonDto pokeApiPokemonDto = restTemplate.getForObject(url, PokeApiPokemonDto.class);
		assert pokeApiPokemonDto != null;
		return pokeApiPokemonDto;
	}

}
