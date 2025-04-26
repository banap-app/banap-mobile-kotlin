package com.banap.banap.domain.use_case.login

import com.banap.banap.common.Resource
import com.banap.banap.data.model.TokenVerificationResponse
import com.banap.banap.data.repository.LoginRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class TokenVerificationUseCase @Inject constructor(
    private val repository: LoginRepositoryImpl
) {
    operator fun invoke(token: String) : Flow<Resource<TokenVerificationResponse>> = flow {
        try {
            emit(Resource.Loading())
            val tokenVerificationResponse = repository.verifyToken(token)
            emit(Resource.Success(tokenVerificationResponse))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Um erro inesperado aconteceu"))
        } catch (e: IOException) {
            emit(Resource.Error("Não foi possível acessar o servidor. Verifique sua conexão com a internet"))
        }
    }
}