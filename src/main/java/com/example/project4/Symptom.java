package com.example.project4;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Symptom {
    String name;
    LocalDate date;
    double risk;

    public Symptom(String name, LocalDate date, double risk) {
        this.name = name;
        this.date = date;
        this.risk = risk;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", risk=" + risk +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public double getRisk() {
        return risk;
    }
}

