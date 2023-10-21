package com.example.proyecto.model

import jakarta.persistence.*

@Entity
@Table(name = "doctores")
class Doctores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombredoc: String? = null
    var especialidaddoc: String? = null
    var telefonodoc: String? = null
}