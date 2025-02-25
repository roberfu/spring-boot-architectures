package cl.springmachine.clean.infrastructure.external;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class PokemonExternalDto {

	private Integer id;

	private String name;

	private List<PokemonType> types;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PokemonType {
		private Integer slot;
		private Type type;

	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Type {
		private String name;
	}

}
