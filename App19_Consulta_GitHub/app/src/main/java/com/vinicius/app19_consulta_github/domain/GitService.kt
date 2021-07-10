package com.vinicius.app19_consulta_github.domain

import com.vinicius.app19_consulta_github.data.model.Usuario
import retrofit2.Response
import retrofit2.http.*

interface GitService {
    @GET("{user}")
    suspend fun buscarUser(
        @Path("user") user: String
    ) : Response<Usuario>
}