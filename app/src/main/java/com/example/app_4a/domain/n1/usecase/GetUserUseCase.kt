package com.example.app_4a.domain.n1.usecase

import com.example.app_4a.data.repository.UserRepository
import com.example.app_4a.domain.n1.entity.User

class GetUserUseCase(private val userRepository: UserRepository) {

        suspend fun invoke(email: String) : User {
            return userRepository.getUser(email)
        }
}