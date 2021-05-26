package br.com.zup.edu.cadastraAutor

import br.com.zup.edu.CadastraAutorServiceGrpc
import br.com.zup.edu.NovoAutorRequest
import br.com.zup.edu.NovoAutorResponse
import io.grpc.stub.StreamObserver

class CadastraAutorEndpoint : CadastraAutorServiceGrpc.CadastraAutorServiceImplBase() {

    override fun cadastraAutor(request: NovoAutorRequest?,
                               responseObserver: StreamObserver<NovoAutorResponse>?) {

       // TODO
        Autor(nome=  request.nome,
              email = request.email,
              descricao = request.descricao)

       val autor = request.toModel()
    }
}