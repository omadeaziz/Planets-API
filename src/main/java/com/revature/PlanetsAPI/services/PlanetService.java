package com.revature.PlanetsAPI.services;

import com.revature.PlanetsAPI.models.Planet;
import com.revature.PlanetsAPI.repo.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {
    private PlanetRepository planetRepo;

    public PlanetService(PlanetRepository planetRepo) {
        this.planetRepo = planetRepo;
    }

    public boolean saveMyPlanet(Planet p) {
        //we cannot allow "Pluto" to be added

        if (p.getName().equalsIgnoreCase("pluto")) {
            return false;
        } else {
            planetRepo.save(p);
            return true;
        }
    }

    public List<Planet> getAllPlanets() {
        return planetRepo.findAll();
    }

    public Planet getPlanetByName(String s) {
        if (s.equalsIgnoreCase("pluto")) {
            return new Planet(-1, "no planet of that name exists!", -10);

        } else {
            Planet newPlanet = planetRepo.findByName(s);

            if (newPlanet == null) {
                return new Planet(-1, "no planet of that name exists!", -10);

            } else {
                return newPlanet;
            }
        }
    }

}
