package cl.springmachine.onion.repositories;

import cl.springmachine.onion.entities.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
