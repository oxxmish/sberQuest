package com.sber.quest.service

import com.sber.quest.models.auth.Status
import com.sber.quest.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AdminService(private val userRepository: UserRepository) {

    fun approveRegistration(userId: Long) {
        processRegistration(userId, Status.ACTIVE)
    }

    fun declineRegistration(userId: Long) {
        processRegistration(userId, Status.DISABLED)
    }

    fun processRegistration(userId: Long, status: Status) {
        var user = userRepository.findById(userId).orElseThrow{ RuntimeException("User not found") }
        if (user.status == Status.WAITING_APPROVE) {
            user.status = status
            userRepository.save(user)
        } else
            throw RuntimeException("This user already approved/declined")
    }
}