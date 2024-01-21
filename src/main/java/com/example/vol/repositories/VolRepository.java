package com.example.vol.repositories;

import com.example.vol.models.Client;
import com.example.vol.models.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Transactional()
public interface VolRepository extends JpaRepository<Vol, Integer> {
    Vol findByNumVol(int id);

}
