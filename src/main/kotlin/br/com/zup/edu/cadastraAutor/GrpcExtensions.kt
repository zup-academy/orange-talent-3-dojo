package br.com.zup.edu.cadastraAutor

import br.com.zup.edu.NovoAutorRequest

fun NovoAutorRequest.toModel(): Autor {
    return Autor(
        nome = nome,
        email = email,
        descricao = descricao
    )
}