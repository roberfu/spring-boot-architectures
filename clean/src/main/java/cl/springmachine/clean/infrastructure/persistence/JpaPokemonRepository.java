package cl.springmachine.clean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.springmachine.clean.domain.model.Pokemon;
import cl.springmachine.clean.domain.repository.PokemonRepository;

public interface JpaPokemonRepository extends JpaRepository<Pokemon, Integer>, PokemonRepository {

}
