package cl.springmachine.clean.application.operations;

import org.springframework.stereotype.Component;

import cl.springmachine.clean.domain.model.Pokemon;
import cl.springmachine.clean.domain.repository.PokemonRepository;
import cl.springmachine.clean.infrastructure.external.ExternalPokeApiClient;
import cl.springmachine.clean.infrastructure.external.PokemonExternalDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreatePokemonUseCaseImpl implements CreatePokemonUseCase {

	private final ExternalPokeApiClient client;

	private final PokemonRepository repository;

	@Override
	public Integer createPokemon(String name) {
		PokemonExternalDto pokemonExternalDto = client.findPokemon(name);
		Pokemon pokemon = repository.save(Pokemon.builder().name(pokemonExternalDto.getName())
				.pokedexNumber(pokemonExternalDto.getId()).type(pokemonExternalDto.getTypes().stream().findFirst()
						.map(pokemonType -> pokemonType.getType().getName()).orElseThrow())
				.build());
		return pokemon.getPokedexNumber();
	}

}
