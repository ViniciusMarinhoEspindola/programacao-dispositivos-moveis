package com.vinicius.app18_consulta_cep.domain

import com.vinicius.app18_consulta_cep.data.model.Endereco
import retrofit2.Response
import retrofit2.http.*

interface EnderecoService {
    @GET("{cep}/json")
    suspend fun buscarEndereco(
        @Path("cep") cep: String
    ) : Response<Endereco>
}