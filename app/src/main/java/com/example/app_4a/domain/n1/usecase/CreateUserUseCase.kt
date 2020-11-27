package com.example.app_4a.domain.n1.usecase

import com.example.app_4a.data.repository.UserRepository
import com.example.app_4a.domain.n1.entity.User

class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}