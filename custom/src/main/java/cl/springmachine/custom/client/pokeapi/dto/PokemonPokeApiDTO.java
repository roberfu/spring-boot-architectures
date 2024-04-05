package cl.springmachine.custom.client.pokeapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonPokeApiDTO {

    private Integer id;

    private String name;
}
