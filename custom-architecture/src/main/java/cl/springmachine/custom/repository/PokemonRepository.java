package cl.springmachine.custom.repository;

import cl.springmachine.custom.repository.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {

    Optional<PokemonEntity> findByPokedexNumber(Integer pokedexNumber);
}
