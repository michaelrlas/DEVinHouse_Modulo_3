package br.com.devinhouse.mypets.controller;

import br.com.devinhouse.mypets.model.UsuarioModel;
import br.com.devinhouse.mypets.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;

    }

    @GetMapping
    public List<UsuarioModel> getAll(){
        return service.getAll();

    }
}
