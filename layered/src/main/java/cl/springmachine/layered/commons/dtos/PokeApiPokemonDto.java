package cl.springmachine.layered.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokeApiPokemonDto {

    private Integer id;

    private String name;
}
