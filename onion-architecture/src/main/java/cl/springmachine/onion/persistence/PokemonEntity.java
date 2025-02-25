package cl.springmachine.onion.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pokemon")
public class PokemonEntity {

	@Id
	@Column(unique = true, name = "pokedex_number")
	private Integer pokedexNumber;

	@Column(unique = true)
	private String name;

	private String type;

}
