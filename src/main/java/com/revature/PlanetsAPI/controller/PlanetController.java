package com.revature.PlanetsAPI.controller;

import com.revature.PlanetsAPI.models.Planet;
import com.revature.PlanetsAPI.repo.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanetController {
    // Should create CRUD methods

    // create dependency
    @Autowired
    PlanetRepository myGalaxy;

    @PostMapping("/planet")
    public void createPlanet(@RequestBody Planet incomingPlanet) {
        myGalaxy.save(incomingPlanet);

    }

    @DeleteMapping("/planet")
    public void deletePlanet() {

    }

    @GetMapping("/planet/{name}")
    public Planet viewPlanetByName(@PathVariable String name) {

        Planet outGoingPlanet = myGalaxy.findByName(name);
        return outGoingPlanet;
        //return myGalaxy.findByName(name);
    }

    @GetMapping("/planets")
    public List<Planet> viewAllPlanet() {
        return myGalaxy.findAll();
    }
}
