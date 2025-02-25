package cl.springmachine.onion.presenter;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonDto {

	private String name;

	@JsonProperty("pokedex_number")
	private Integer pokedexNumber;
	
	private String type;

}
