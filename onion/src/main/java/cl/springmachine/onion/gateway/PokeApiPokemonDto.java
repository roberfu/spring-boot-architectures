package cl.springmachine.onion.gateway;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeApiPokemonDto {

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
