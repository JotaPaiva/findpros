package br.com.techsolutions.findpros.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroContato(

        @NotBlank
        String nome,

        @NotBlank
        String especialidade,

        @NotBlank
        String telefone,

        String email,

        @NotBlank
        String cidade,

        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$", message = "A UF deve ter exatamente duas letras maiúsculas.")
        String estado

) {}
