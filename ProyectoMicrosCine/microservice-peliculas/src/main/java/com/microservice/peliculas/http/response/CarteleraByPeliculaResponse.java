package com.microservice.peliculas.http.response;

import com.microservice.peliculas.Model.dto.CarteleraDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarteleraByPeliculaResponse {
    private String peliculaNombre;
    private int duracion;
    private List<CarteleraDTO> carteleraDTOList;
}
