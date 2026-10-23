package com.devtrack.backend.service;

import com.devtrack.backend.entity.Comment;
import com.devtrack.backend.repository.CommentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll() { return commentRepository.findAll(); }
    public Comment findById(Long id) { return commentRepository.findById(id).orElseThrow(); }
    public Comment save(Comment comment) { return commentRepository.save(comment); }
}