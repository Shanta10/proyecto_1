package com.example.proyecto.model

import jakarta.persistence.*

@Entity
@Table(name = "pacientes")
class Pacientes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombrepaciente: String? = null
    var edadpaciente: String? = null
    @Column (name="doctores_id")
    var doctoresId: Long? = null
}