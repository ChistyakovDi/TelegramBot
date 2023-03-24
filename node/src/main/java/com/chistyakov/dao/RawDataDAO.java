package com.chistyakov.dao;

import com.chistyakov.entity.RawData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RawDataDAO extends JpaRepository<RawData, Long> {
}
