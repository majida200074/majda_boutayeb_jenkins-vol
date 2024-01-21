package com.example.vol.repositories;

import com.example.vol.models.Passager;
import com.example.vol.models.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

@Transactional()
public interface PassagerRepository extends JpaRepository<Passager, Integer> {
    Passager findByIdPas(int id);
}
