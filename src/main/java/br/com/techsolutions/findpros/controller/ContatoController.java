package br.com.techsolutions.findpros.controller;

import br.com.techsolutions.findpros.domain.Contato;
import br.com.techsolutions.findpros.domain.DadosCadastroContato;
import br.com.techsolutions.findpros.repository.ContatoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario() {
        return "contatos/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista",repository.findAll());
        return "contatos/listagem";
    }

    @PostMapping
    public String cadastraContato(@Valid DadosCadastroContato dados) {

        var contato = new Contato(dados);
        repository.save(contato);

        return "redirect:/contatos";

    }

}
