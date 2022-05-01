package com.revature.PlanetsAPI.repo;

import com.revature.PlanetsAPI.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {

    Planet findByName(String name);

}
