package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="localidad")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Localidad extends Base {
    private String denominacion;

}
