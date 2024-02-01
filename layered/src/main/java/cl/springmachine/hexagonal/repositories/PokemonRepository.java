package cl.springmachine.hexagonal.repositories;

import cl.springmachine.hexagonal.entities.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
