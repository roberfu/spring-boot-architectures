package cl.springmachine.hexagonal.adapters.outbound;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRepositoryAdapter extends JpaRepository<PokemonEntity, Integer> {

    Optional<PokemonEntity> findByPokedexNumber(Integer pokedexNumber);
}
