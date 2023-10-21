package com.example.proyecto.repository

import com.example.proyecto.model.Doctores
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctoresRepository : JpaRepository<Doctores, Long?> {

    fun findById (id: Long?): Doctores?
}