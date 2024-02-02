package cl.springmachine.clean.domain.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {

    private Integer id;

    private String name;

    private Integer pokedexNumber;
}
