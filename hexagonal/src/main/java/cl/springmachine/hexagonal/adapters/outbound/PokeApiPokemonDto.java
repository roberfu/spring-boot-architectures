package cl.springmachine.hexagonal.adapters.outbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeApiPokemonDto {

    private Integer id;

    private String name;
}
