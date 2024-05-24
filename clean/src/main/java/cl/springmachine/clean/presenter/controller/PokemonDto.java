package cl.springmachine.clean.presenter.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonDto {

	private Integer pokedexNumber;

	private String name;

	private String type;

}
