package com.university.management.repository;

import com.university.management.entity.session.abstractSession.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
