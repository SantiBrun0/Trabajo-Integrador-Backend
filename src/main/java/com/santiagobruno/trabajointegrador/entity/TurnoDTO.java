package com.santiagobruno.trabajointegrador.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TurnoDTO {

    private String codigo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fecha;

    private String matricula;

    private String dni;

}
