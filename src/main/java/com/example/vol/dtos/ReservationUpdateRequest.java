package com.example.vol.dtos;


import com.example.vol.models.Passager;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class ReservationUpdateRequest {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateRes;
    private int nbrePlace;

    private List<Passager> passagerList;


    public Date getDateRes() {
        return dateRes;
    }

    public void setDateRes(Date dateRes) {
        this.dateRes = dateRes;
    }

    public int getNbrePlace() {
        return nbrePlace;
    }

    public void setNbrePlace(int nbrePlace) {
        this.nbrePlace = nbrePlace;
    }

    public List<Passager> getPassagerList() {
        return passagerList;
    }

    public void setPassagerList(List<Passager> passagerList) {
        this.passagerList = passagerList;
    }
}
