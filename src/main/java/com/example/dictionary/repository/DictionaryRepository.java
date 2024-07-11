package com.example.dictionary.repository;

import com.example.dictionary.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dictionary.model.Dictionary;

import java.util.List;
import java.util.Optional;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    void deleteByCode(String code);
    Optional<Dictionary> findByCode(String code);
}
