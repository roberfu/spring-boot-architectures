package cl.springmachine.onion.ports.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonDto {

    private Integer id;

    private String name;

    @JsonProperty("pokedex_number")
    private Integer pokedexNumber;
}
