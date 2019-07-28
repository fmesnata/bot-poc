package com.lamri.botpoc.chat.dao;

import com.lamri.botpoc.chat.model.Intent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IntentDAO extends JpaRepository<Intent, Long> {

    Optional<Intent> findByLabel(String label);
}
