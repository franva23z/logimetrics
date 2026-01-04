package com.logimetrics.api.model;

public class CalculoRota {
    private String origem;
    private String destino;
    private double distanciaKm;
    private Long maquinaId;

    public CalculoRota() {}
    
    public double getDistanciaKm() { return distanciaKm; }
    public void setDistanciaKm(double distanciaKm) { this.distanciaKm = distanciaKm; }
    public Long getMaquinaId() { return maquinaId; }
    public void setMaquinaId(Long maquinaId) { this.maquinaId = maquinaId; }
}