package com.devtrack.backend.service;

import com.devtrack.backend.entity.Notification;
import com.devtrack.backend.repository.NotificationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> findAll() { return notificationRepository.findAll(); }
    public Notification findById(Long id) { return notificationRepository.findById(id).orElseThrow(); }
    public Notification save(Notification notification) { return notificationRepository.save(notification); }
}