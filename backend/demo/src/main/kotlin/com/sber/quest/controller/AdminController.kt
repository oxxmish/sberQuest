package com.sber.quest.controller

import com.sber.quest.service.AdminService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
class AdminController(private val adminService: AdminService) {

    @PostMapping("/register/approve/{userId}")
    fun approveRegisterRq(@PathVariable userId: Long) = adminService.approveRegistration(userId)

    @PostMapping("/register/decline/{userId}")
    fun declineRegisterRq(@PathVariable userId: Long) = adminService.declineRegistration(userId)

    @GetMapping("/leaders")
    fun getLeadersList() = adminService.getLeadersList()

    @GetMapping("/waiting")
    fun getWaitingUsersList() = adminService.getWaitingLeaders()
}