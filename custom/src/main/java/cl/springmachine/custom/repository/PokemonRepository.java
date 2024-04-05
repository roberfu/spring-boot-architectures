package cl.springmachine.custom.repository;

import cl.springmachine.custom.repository.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
