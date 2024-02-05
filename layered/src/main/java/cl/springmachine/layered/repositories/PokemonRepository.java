package cl.springmachine.layered.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.springmachine.layered.entities.PokemonEntity;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
