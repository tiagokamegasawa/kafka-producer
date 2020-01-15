package br.com.fiap.producer.controller

import br.com.fiap.producer.service.BolsaFamiliaService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bolsa-familia")
class BolsaFamiliaController(
    private val bolsaFamiliaService: BolsaFamiliaService
) {

    @PostMapping
    fun sendFileToTopic() {
        this.bolsaFamiliaService.sendFileToTopic()
    }

}