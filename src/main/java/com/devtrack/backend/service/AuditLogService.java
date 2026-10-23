package com.devtrack.backend.service;

import com.devtrack.backend.entity.AuditLog;
import com.devtrack.backend.repository.AuditLogRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public List<AuditLog> findAll() { return auditLogRepository.findAll(); }
    public AuditLog findById(Long id) { return auditLogRepository.findById(id).orElseThrow(); }
    public AuditLog save(AuditLog auditLog) { return auditLogRepository.save(auditLog); }
}