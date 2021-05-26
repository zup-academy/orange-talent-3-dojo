package br.com.zup.edu.cadastraAutor

import io.grpc.StatusRuntimeException

class EmailDuplicadoException (mensagem:String): StatusRuntimeException(mensagem){
}