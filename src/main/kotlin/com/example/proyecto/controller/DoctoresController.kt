package com.example.proyecto.controller

import com.example.proyecto.model.Doctores
import com.example.proyecto.service.DoctoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/doctores")   //endpoint
class DoctoresController {
    @Autowired
    lateinit var doctoresService: DoctoresService

    @GetMapping
    fun list ():List <Doctores>{
        return doctoresService.list()
    }
    @PostMapping
    fun save (@RequestBody doctores: Doctores):ResponseEntity<Doctores>{
        return ResponseEntity(doctoresService.save(doctores), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody doctores: Doctores):ResponseEntity<Doctores>{
        return ResponseEntity(doctoresService.update(doctores), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody doctores: Doctores):ResponseEntity<Doctores>{
        return ResponseEntity(doctoresService.updateName(doctores), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(doctoresService.listById (id), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return doctoresService.delete(id)
    }
}