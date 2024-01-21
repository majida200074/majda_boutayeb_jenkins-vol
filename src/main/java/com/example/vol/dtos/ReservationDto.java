package com.example.vol.dtos;

import java.sql.Date;

public class ReservationDto {
    private Date dateRes;
    private int nbrePlace;
    private int idClt;

    private int numVol;

    private int idPas;

    public int getIdPas() {
        return idPas;
    }

    public void setIdPas(int idPas) {
        this.idPas = idPas;
    }

    public int getNumVol() {
        return numVol;
    }

    public void setNumVol(int numVol) {
        this.numVol = numVol;
    }

    public Date getDateRes() {
        return dateRes;
    }

    public int getNbrePlace() {
        return nbrePlace;
    }

    public int getIdClt() {
        return idClt;
    }

    public void setDateRes(Date dateRes) {
        this.dateRes = dateRes;
    }

    public void setNbrePlace(int nbrePlace) {
        this.nbrePlace = nbrePlace;
    }

    public void setIdClt(int idClt) {
        this.idClt = idClt;
    }
}
