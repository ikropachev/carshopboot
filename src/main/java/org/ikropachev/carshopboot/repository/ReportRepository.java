package org.ikropachev.carshopboot.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.carshopboot.model.Client;
import org.ikropachev.carshopboot.model.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Report Controller")
public interface ReportRepository  extends BaseRepository<Report> {
    @Query("SELECT r FROM Report r WHERE r.date=:date ORDER BY r.client.name, r.revenue")
    List<Report> getAllByDate(@Param("date") LocalDate date);

    @Query("SELECT SUM(r.revenue) FROM Report r WHERE r.date BETWEEN :beginDate AND :endDate")
    Integer getRevenueByPeriod(@Param("beginDate") LocalDate beginDate, @Param("endDate") LocalDate endDate);
}
