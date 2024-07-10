package com.example.dictionary.repository;

import com.example.dictionary.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dictionary.model.Dictionary;

public interface DataRepository extends JpaRepository<Data, Long> {
}
