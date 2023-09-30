package br.com.techsolutions.findpros.controller;

import br.com.techsolutions.findpros.domain.Contato;
import br.com.techsolutions.findpros.domain.DadosCadastroContato;
import br.com.techsolutions.findpros.infra.ValidationErrorResponse;
import br.com.techsolutions.findpros.infra.ValidationSuccessResponse;
import br.com.techsolutions.findpros.repository.ContatoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/contatos/formulario")
    public ResponseEntity<?> validar(@Valid DadosCadastroContato dados, BindingResult result) {
        if (result.hasErrors()) {
            // Se houver erros de validação, construa uma resposta com os detalhes do erro
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(new ValidationErrorResponse(errors));
        } else {
            // Caso contrário, a validação foi bem-sucedida
            return ResponseEntity.ok(new ValidationSuccessResponse());
        }
    }

}
