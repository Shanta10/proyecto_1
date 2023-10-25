package com.example.proyecto.service

import com.example.proyecto.model.Doctores
import com.example.proyecto.model.Pacientes
import com.example.proyecto.repository.DoctoresRepository
import com.example.proyecto.repository.PacientesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PacientesService {
    @Autowired
    lateinit var pacientesRepository: PacientesRepository

    fun list ():List<Pacientes>{
        return pacientesRepository.findAll()
    }
    fun save(pacientes: Pacientes): Pacientes {
        try{
            return pacientesRepository.save(pacientes)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(pacientes: Pacientes): Pacientes {
        try {
            pacientesRepository.findById(pacientes.id)
                ?: throw Exception("ID no existe")

            return pacientesRepository.save(pacientes)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(pacientes: Pacientes): Pacientes {
        try{
            val response = pacientesRepository.findById(pacientes.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombrepaciente=pacientes.nombrepaciente
            }
            return pacientesRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?): Pacientes?{
        return pacientesRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = pacientesRepository.findById(id)
                ?: throw Exception("ID no existe")
            pacientesRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}