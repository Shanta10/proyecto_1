package com.example.proyecto.service

import com.example.proyecto.model.Doctores
import com.example.proyecto.repository.DoctoresRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Service
class DoctoresService {
    @Autowired
    lateinit var doctoresRepository: DoctoresRepository

    fun list ():List<Doctores>{
        return doctoresRepository.findAll()
    }
    fun save(doctores: Doctores): Doctores {
        try{
            return doctoresRepository.save(doctores)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
}
    fun update(doctores: Doctores): Doctores{
        try {
            doctoresRepository.findById(doctores.id)
                ?: throw Exception("ID no existe")

            return doctoresRepository.save(doctores)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(doctores: Doctores): Doctores{
        try{
            val response = doctoresRepository.findById(doctores.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombredoc=doctores.nombredoc
            }
            return doctoresRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Doctores?{
        return doctoresRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = doctoresRepository.findById(id)
                ?: throw Exception("ID no existe")
            doctoresRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}