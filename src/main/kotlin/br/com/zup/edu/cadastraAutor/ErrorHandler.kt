package br.com.zup.edu.cadastraAutor

import io.grpc.Status
import io.grpc.stub.StreamObserver
import io.micronaut.aop.Around
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import java.lang.RuntimeException
import kotlin.annotation.AnnotationTarget.*

@Around
@Retention(AnnotationRetention.RUNTIME)
@Target(FUNCTION, PROPERTY_SETTER, PROPERTY_GETTER, CLASS)
annotation class ErrorHandler()

class ErrorInterceptor: MethodInterceptor<Any, Any> {

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any {

        return try {
            context.proceed()
        }catch (e: RuntimeException){
            val observer = context
                .parameterValues
                .filterIsInstance<StreamObserver<*>>()
                .firstOrNull() as StreamObserver
            when(e){
                is EmailDuplicadoException -> {
                    observer.onError(Status.ALREADY_EXISTS.withDescription(e.message).withCause(e).asRuntimeException())
                }
                else -> observer.onError(Status.UNKNOWN)
            }
        }
    }
}