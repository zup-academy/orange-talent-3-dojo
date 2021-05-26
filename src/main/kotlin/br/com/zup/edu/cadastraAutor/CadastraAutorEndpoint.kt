package br.com.zup.edu.cadastraAutor

import br.com.zup.edu.CadastraAutorServiceGrpc
import br.com.zup.edu.NovoAutorRequest
import br.com.zup.edu.NovoAutorResponse
import io.grpc.stub.StreamObserver
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CadastraAutorEndpoint : CadastraAutorServiceGrpc.CadastraAutorServiceImplBase() {

    @Inject lateinit var repository: AutorRepository

    override fun cadastraAutor(
        request: NovoAutorRequest,
        responseObserver: StreamObserver<NovoAutorResponse>
    ) {

        val autor = request.toModel()
        repository.save(autor)

        responseObserver.onNext(NovoAutorResponse.newBuilder().setId(autor.id.toString()).build())
        responseObserver.onCompleted()
    }
}