package com.devtrack.backend.service;

import com.devtrack.backend.entity.ProjectMember;
import com.devtrack.backend.entity.ProjectMemberId;
import com.devtrack.backend.repository.ProjectMemberRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;

    public ProjectMemberService(ProjectMemberRepository projectMemberRepository) {
        this.projectMemberRepository = projectMemberRepository;
    }

    public List<ProjectMember> findAll() { return projectMemberRepository.findAll(); }
    public ProjectMember findById(ProjectMemberId id) { return projectMemberRepository.findById(id).orElseThrow(); }
    public ProjectMember save(ProjectMember member) { return projectMemberRepository.save(member); }
}