package com.revature.PlanetsAPI.controller;

import com.revature.PlanetsAPI.models.Planet;
import com.revature.PlanetsAPI.repo.PlanetRepository;
import com.revature.PlanetsAPI.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanetController {
    // Should create CRUD methods

    // create dependency
    @Autowired
    PlanetService planetService;

    @PostMapping("/planet")
    public void createPlanet(@RequestBody Planet incomingPlanet) {
        boolean success = planetService.saveMyPlanet(incomingPlanet);

        if (success == false) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT,"we don't allow Pluto's here");
        }

    }

    @DeleteMapping("/planet")
    public void deletePlanet() {

    }

    @GetMapping("/planet/{name}")
    public Planet viewPlanetByName(@PathVariable String name) {

        Planet outGoingPlanet = planetService.getPlanetByName(name);
        return outGoingPlanet;
        //return myGalaxy.findByName(name);
    }

    @GetMapping("/planets")
    public List<Planet> viewAllPlanet() {
        return planetService.getAllPlanets();
    }
}
