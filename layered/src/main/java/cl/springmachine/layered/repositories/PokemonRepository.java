package cl.springmachine.layered.repositories;

import cl.springmachine.layered.entities.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
