package kz.enactus.ecoalmaty.api.repository

import kz.enactus.ecoalmaty.api.model.entity.ExceptionLog
import org.springframework.data.jpa.repository.JpaRepository

interface ExceptionLogRepository : JpaRepository<ExceptionLog, Long>