package cl.springmachine.layered.commons.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonDto {

    private Integer id;

    private String name;

    @JsonProperty("pokedex_number")
    private Integer pokedexNumber;
}
