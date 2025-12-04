package com.example.todaysSun.repository;


import com.example.todaysSun.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

    // ✅ 날짜 범위로 일기 검색
    List<Diary> findByDateBetween(LocalDate start, LocalDate end);

    List<Diary> findAllByDate(LocalDate date);

    // ✅ 연도만 중복 없이 가져오기 (PostgreSQL용)
    @Query("SELECT DISTINCT EXTRACT(YEAR FROM d.date) FROM Diary d ORDER BY EXTRACT(YEAR FROM d.date)")
    List<Integer> findDistinctYears();

    Optional<Diary> findByDate(LocalDate date);

}
