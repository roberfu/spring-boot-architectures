package cl.springmachine.onion.adapters.outbound;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositoryAdapter extends JpaRepository<PokemonEntity, Integer> {
}
