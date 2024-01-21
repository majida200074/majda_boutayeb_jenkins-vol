package com.example.vol.controllers;

import com.example.vol.models.Client;
import com.example.vol.models.Passager;
import com.example.vol.models.Vol;
import com.example.vol.repositories.PassagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/pass")
public class PassagerController {

    @Autowired
    private PassagerRepository passagerRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Passager> getAllPassagers() {
        return passagerRepository.findAll();
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public ResponseEntity<Passager> addPassager(@RequestBody Passager p) {
        Passager pass = passagerRepository.save(p);
        if (pass == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(pass, HttpStatus.CREATED);
    }

    @PutMapping(value = "/id/{id}")
    public Passager updatePassager(@RequestBody Passager p) {
        return passagerRepository.saveAndFlush(p);
    }




    @GetMapping("/id/{id}")
    public Optional<Passager> findById(@PathVariable Integer id) {
        return passagerRepository.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Integer id) {
        passagerRepository.deleteById(id);
    }

    @GetMapping("/getpassager/{id}")
    public  Passager getbyid(@PathVariable Integer id){
        return this.passagerRepository.findById(id).get();
    }



}
