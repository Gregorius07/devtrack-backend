package com.devtrack.backend.service;

import com.devtrack.backend.entity.Issue;
import com.devtrack.backend.repository.IssueRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public List<Issue> findAll() { return issueRepository.findAll(); }
    public Issue findById(Long id) { return issueRepository.findById(id).orElseThrow(); }
    public Issue save(Issue issue) { return issueRepository.save(issue); }
}