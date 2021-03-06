package org.ikropachev.carshopboot.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.carshopboot.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Report Controller")
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query("SELECT r FROM Report r ORDER BY r.date, r.client.name, r.revenue")
    List<Report> getAll();

    @Query("SELECT SUM(r.revenue) FROM Report r WHERE r.date BETWEEN :beginDate AND :endDate")
    Integer getRevenueByPeriod(@Param("beginDate") LocalDate beginDate, @Param("endDate") LocalDate endDate);
}
