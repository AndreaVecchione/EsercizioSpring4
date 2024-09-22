package com.example.EsercizioSpring4.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class Controller {

    @Operation(summary = "Nome", description = "Quando diamo il parametro del nome, ci restituisce indietro il nome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "300", description = "Nome è stato inserito correttamente"),
            @ApiResponse(responseCode = "600", description = "Il nome insierito è errato")
    })
    @GetMapping("/Name")
    public String getName(@Parameter(name = "Nome", description = "Il nome ridato indietro") @RequestParam(name = "nome") String name) {
        return name;
    }

    @Operation(summary = "mostra il nome al contrario", description = "quando inseriamo il parametro name, verrà mostrato il nome al contrario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "300", description = "Nome è stato inserito correttamente"),
            @ApiResponse(responseCode = "600", description = "Il nome insierito è errato")
    })
    @PostMapping("/emaN")
    public String postName(@Parameter(name = "nome", description = "il nome è stato capovolto") @RequestParam(name = "nome") String name) {
        StringBuilder nameString = new StringBuilder(name);
        return nameString.reverse().toString();
    }
}
