package com.example.huellacarbono.model;

public class ActividadCarbono {

    private int id;
    private String tipoActividad;
    private double cantidad;
    private double emisionesCO2;
    private String fecha;

    public ActividadCarbono() {}

    public ActividadCarbono(String tipoActividad, double cantidad, String fecha) {
        this.tipoActividad = tipoActividad;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.emisionesCO2 = calcularEmisiones();
    }

    private double calcularEmisiones() {
        switch (tipoActividad) {
            case "Transporte":
                return cantidad * 0.21;
            case "Energía":
                return cantidad * 0.38;
            case "Alimentación":
                return cantidad * 2.5;
            default:
                return 0;
        }
    }

    //  POO
    @Override
    public String toString() {
        return "Actividad: " + tipoActividad +
                "\nCantidad: " + cantidad +
                "\nEmisiones: " + emisionesCO2 + " kg CO₂" +
                "\nFecha: " + fecha;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipoActividad() { return tipoActividad; }
    public void setTipoActividad(String tipoActividad) { this.tipoActividad = tipoActividad; }

    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }

    public double getEmisionesCO2() { return emisionesCO2; }
    public void setEmisionesCO2(double emisionesCO2) { this.emisionesCO2 = emisionesCO2; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
