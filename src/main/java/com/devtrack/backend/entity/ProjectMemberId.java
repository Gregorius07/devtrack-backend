package com.devtrack.backend.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProjectMemberId implements Serializable {

    private Long projectId;
    private Long userId;

    public ProjectMemberId() {
    }

    public ProjectMemberId(Long projectId, Long userId) {
        this.projectId = projectId;
        this.userId = userId;
    }

    public Long getProjectId() { return projectId; }
    public Long getUserId() { return userId; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ProjectMemberId other)) return false;
        return Objects.equals(projectId, other.projectId)
                && Objects.equals(userId, other.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, userId);
    }
}