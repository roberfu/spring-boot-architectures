package cl.springmachine.custom.client.pokeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class PokemonPokeApiDTO {

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
