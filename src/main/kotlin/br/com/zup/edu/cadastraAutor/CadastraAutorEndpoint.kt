package br.com.zup.edu.cadastraAutor

import br.com.zup.edu.CadastraAutorServiceGrpc
import br.com.zup.edu.NovoAutorRequest
import br.com.zup.edu.NovoAutorResponse
import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@Singleton
class CadastraAutorEndpoint : CadastraAutorServiceGrpc.CadastraAutorServiceImplBase() {

    override fun cadastraAutor(
        request: NovoAutorRequest?,
        responseObserver: StreamObserver<NovoAutorResponse>?
    ) {

        val autor = request?.toModel()
    }
}