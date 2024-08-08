package site.dittotrip.ditto_trip.review.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.dittotrip.ditto_trip.review.comment.repository.CommentRepository;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
public class CommentRemoveService {

    private final CommentRepository commentRepository;

}
