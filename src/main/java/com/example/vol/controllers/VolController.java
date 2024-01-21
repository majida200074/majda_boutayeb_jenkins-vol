package com.example.vol.controllers;

import com.example.vol.models.Client;
import com.example.vol.models.Passager;
import com.example.vol.models.Vol;
import com.example.vol.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vols")
public class VolController {

    @Autowired
    private VolRepository volRepository;

    @GetMapping("/list")
    public List<Vol> getAllVols() {
        return volRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Vol> addVol(@RequestBody Vol v) {
        Vol vol = volRepository.save(v);
        if (vol == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(vol, HttpStatus.CREATED);
    }



    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Integer id) {
        volRepository.deleteById(id);
    }








    @PutMapping("/update/{id}")
    public ResponseEntity<Vol> updateVol(@PathVariable Integer id, @RequestBody Vol updatedVol) {
        Optional<Vol> optionalVol = volRepository.findById(id);
        if (optionalVol.isPresent()) {
            Vol vol = optionalVol.get();
            vol.setDateDepart(updatedVol.getDateDepart());
            vol.setHeureDepart(updatedVol.getHeureDepart());
            vol.setDateArrive(updatedVol.getDateArrive());
            vol.setHeureArrive(updatedVol.getHeureArrive());
            vol.setVilleDepart(updatedVol.getVilleDepart());
            vol.setVilleArrive(updatedVol.getVilleArrive());
            vol.setPrix(updatedVol.getPrix());
            vol.setAvion(updatedVol.getAvion());
            vol.setNbrePlace(updatedVol.getNbrePlace());
            vol.setNbrePlaceRestant(updatedVol.getNbrePlaceRestant());
            vol.setEtat(updatedVol.isEtat());

            // Mettez à jour les autres propriétés du vol de la même manière

            Vol savedVol = volRepository.save(vol);
            return new ResponseEntity<>(savedVol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/{id}")
    public ResponseEntity<Vol> getVolById(@PathVariable Integer id) {
        Optional<Vol> optionalVol = volRepository.findById(id);
        if (optionalVol.isPresent()) {
            Vol vol = optionalVol.get();
            return new ResponseEntity<>(vol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}


    

