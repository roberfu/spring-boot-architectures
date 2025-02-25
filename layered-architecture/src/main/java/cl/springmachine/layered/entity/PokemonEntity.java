package cl.springmachine.layered.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pokemon")
public class PokemonEntity {

    @Id
    @Column(name = "pokedex_number")
    private Integer pokedexNumber;

    @Column(unique = true)
    private String name;

    private String type;

}