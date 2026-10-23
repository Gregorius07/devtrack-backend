package com.devtrack.backend.repository;

import com.devtrack.backend.entity.ProjectMember;
import com.devtrack.backend.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
}