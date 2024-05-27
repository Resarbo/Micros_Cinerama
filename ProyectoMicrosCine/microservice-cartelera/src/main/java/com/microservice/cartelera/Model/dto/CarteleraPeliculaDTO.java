package com.microservice.cartelera.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CarteleraPeliculaDTO {
    private int carteleraId;

    private boolean estado;
    private double precio;
    private String peliculaNombre;
    private String sala;
    private String horario;
    private int peliculaId;

    public int getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(int peliculaId) {
        this.peliculaId = peliculaId;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPeliculaNombre() {
        return peliculaNombre;
    }

    public void setPeliculaNombre(String peliculaNombre) {
        this.peliculaNombre = peliculaNombre;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCarteleraId() {
        return carteleraId;
    }

    public void setCarteleraId(int carteleraId) {
        this.carteleraId = carteleraId;
    }

    public CarteleraPeliculaDTO() {
        super();
    }


}
