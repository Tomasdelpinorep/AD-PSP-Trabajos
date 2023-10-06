package com.salesianos.triana.EjDto_Clase.dto;

import com.salesianos.triana.EjDto_Clase.model.Producto;
import lombok.Builder;

@Builder
public record ProductDTO(Long id,
                         String nombre,
                         double pvp,
                         String imagen,
                         String categoria) {

    public static ProductDTO of(Producto producto){
        return ProductDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .pvp(producto.getPvp())
                .imagen(producto.getImages() != null
                ? producto.getImages().get(1)
                        : "")
                .categoria(producto.getCategory() != null
                ? producto.getCategory().getNombre()
                        : "Sin categoría")
                .build();
    }

}
