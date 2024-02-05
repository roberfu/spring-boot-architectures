package cl.springmachine.layered.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonDto {

	private Integer id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("pokedex_number")
	private Integer pokedexNumber;
}
