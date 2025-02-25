package cl.springmachine.clean.infrastructure.external;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ExternalPokeApiClientImpl implements ExternalPokeApiClient {

	private final RestTemplate restTemplate;

	@Override
	public PokemonExternalDto findPokemon(String name) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + name;
		PokemonExternalDto pokemon = restTemplate.getForObject(url, PokemonExternalDto.class);
		assert pokemon != null;
		return pokemon;
	}

}
