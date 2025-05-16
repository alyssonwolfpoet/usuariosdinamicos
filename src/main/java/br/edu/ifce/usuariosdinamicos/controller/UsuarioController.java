package br.edu.ifce.usuariosdinamicos.controller;

import br.edu.ifce.usuariosdinamicos.entity.Raca;
import br.edu.ifce.usuariosdinamicos.entity.Usuario;
import br.edu.ifce.usuariosdinamicos.repository.UsuarioCustomRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioCustomRepository customRepository;

    public UsuarioController(UsuarioCustomRepository customRepository) {
        this.customRepository = customRepository;
    }

    @GetMapping("/buscar")
    public List<Usuario> buscarUsuarios(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) Raca raca,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFim
    ) {
        return customRepository.findAllUsuarios(nome, email, cpf, raca, dataInicio, dataFim);
    }
}
