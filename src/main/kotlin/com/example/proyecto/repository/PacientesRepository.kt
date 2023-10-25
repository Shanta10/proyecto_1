package com.example.proyecto.repository

import com.example.proyecto.model.Doctores
import com.example.proyecto.model.Pacientes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PacientesRepository : JpaRepository<Pacientes, Long?> {

    fun findById (id: Long?): Pacientes?
}