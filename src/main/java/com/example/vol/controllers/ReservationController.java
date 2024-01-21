package com.example.vol.controllers;

import com.example.vol.dtos.ReservationDto;
import com.example.vol.dtos.ReservationUpdateRequest;
import com.example.vol.models.Client;
import com.example.vol.models.Passager;
import com.example.vol.models.Reservation;
import com.example.vol.models.Vol;
import com.example.vol.repositories.ClientRepository;
import com.example.vol.repositories.PassagerRepository;
import com.example.vol.repositories.ReservationRepository;
import com.example.vol.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/res")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VolRepository volRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
/*    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation r) {
        Reservation res = reservationRepository.save(r);
        if (res == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }*/
    public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDto r) {
        Reservation res = new Reservation();
        res.setNbrePlace(r.getNbrePlace());
        res.setDateRes(r.getDateRes());
        Client client = this.clientRepository.findByIdClt(r.getIdClt());
        res.setClient(client);
        Vol vol =this.volRepository.findByNumVol(r.getNumVol());
        res.setVol(vol);
        Reservation savedRes;
        try {
            savedRes = reservationRepository.save(res);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(savedRes, HttpStatus.CREATED);
    }



    @GetMapping("/id/{id}")
    public Optional<Reservation> findById(@PathVariable Integer id) {
        return reservationRepository.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Integer id) {
        reservationRepository.deleteById(id);
    }







    // reservation.dateRest is of type Date and spring can only serialize it when its epoch mili
    // so it's better to have a dto; ReservationUpdateRequest and have some format on it.
    @PutMapping("/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable int id, @RequestBody ReservationUpdateRequest updatedReservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();

            // Mettez à jour les attributs de la réservation avec les nouvelles valeurs
            reservation.setDateRes(new java.sql.Date(updatedReservation.getDateRes().getTime()));
            reservation.setNbrePlace(updatedReservation.getNbrePlace());
            //reservation.setClient(updatedReservation.getClient());  -- not safe operation, a reservation shouldn't modify the client!!
            reservation.setListPassagers(updatedReservation.getPassagerList());
           // reservation.setVol(updatedReservation.getVol()); -- same as client, both of these resources are one to many so a single reservation shouldn't modify it

            // Enregistrez les modifications dans la base de données
            reservationRepository.save(reservation);

            return ResponseEntity.ok("Réservation mise à jour avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour récupérer une réservation à partir de son ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Autres méthodes du contrôleur...
}

