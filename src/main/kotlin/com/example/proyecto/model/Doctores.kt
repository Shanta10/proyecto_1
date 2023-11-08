package com.example.proyecto.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "doctores")
class Doctores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Campo obligatorio") //validate
    var nombredoc: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    var especialidaddoc: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    var telefonodoc: String? = null
}