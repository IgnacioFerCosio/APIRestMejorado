package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name="autor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Autor extends Base{
    private String nombre;
    private String apellido;
    @Column(name="biografia", length = 1500)
    private String biografia;

}