package cl.springmachine.custom.service.pokemon.dto;

import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder


public class PokemonDTO {
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("pokedex_number")
    private Integer pokedexNumber;
}
