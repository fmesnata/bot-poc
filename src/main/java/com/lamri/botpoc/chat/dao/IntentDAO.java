package com.lamri.botpoc.chat.dao;

import com.lamri.botpoc.chat.model.Intent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntentDAO extends JpaRepository<Intent, Long> {

    Intent findByLabel(String label);
}
