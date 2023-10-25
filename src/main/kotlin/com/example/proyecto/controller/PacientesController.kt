package com.example.proyecto.controller

import com.example.proyecto.model.Doctores
import com.example.proyecto.model.Pacientes
import com.example.proyecto.service.PacientesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pacientes")   //endpoint
class PacientesController {
    @Autowired
    lateinit var pacientesService: PacientesService

    @GetMapping
    fun list ():List <Pacientes>{
        return pacientesService.list()
    }
    @PostMapping
    fun save (@RequestBody pacientes: Pacientes): ResponseEntity<Pacientes> {
        return ResponseEntity(pacientesService.save(pacientes), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody pacientes: Pacientes): ResponseEntity<Pacientes> {
        return ResponseEntity(pacientesService.update(pacientes), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody pacientes: Pacientes): ResponseEntity<Pacientes> {
        return ResponseEntity(pacientesService.updateName(pacientes), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(pacientesService.listById (id), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return pacientesService.delete(id)
    }
}