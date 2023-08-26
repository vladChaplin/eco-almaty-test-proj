package kz.enactus.ecoalmaty.api.repository

import kz.enactus.ecoalmaty.api.model.entity.LoginLog
import org.springframework.data.jpa.repository.JpaRepository

interface LoginLogRepository : JpaRepository<LoginLog, Long>