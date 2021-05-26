package br.com.zup.edu.cadastraAutor

import io.micronaut.core.annotation.Introspected
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Autor(
    @field:NotBlank @Column(nullable = false) val nome: String,
    @field:NotBlank @field:Email @Column(nullable = false, unique = true) val email: String,
    @field:NotBlank @field:Size(max = 400) @Column(nullable = false) val descricao: String
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0L

    @CreationTimestamp
    var criadoEm = LocalDateTime.now()
}
