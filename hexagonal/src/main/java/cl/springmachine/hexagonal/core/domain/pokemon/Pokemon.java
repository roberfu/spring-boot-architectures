package cl.springmachine.hexagonal.core.domain.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

	private Integer id;

	private String name;

	private Integer pokedexNumber;

}
