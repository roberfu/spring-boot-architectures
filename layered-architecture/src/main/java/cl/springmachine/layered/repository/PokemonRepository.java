package cl.springmachine.layered.repository;

import cl.springmachine.layered.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
