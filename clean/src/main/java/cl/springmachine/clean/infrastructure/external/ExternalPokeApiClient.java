package cl.springmachine.clean.infrastructure.external;

public interface ExternalPokeApiClient {

	PokemonExternalDto findPokemon(String name);

}
