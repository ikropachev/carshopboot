package org.ikropachev.carshopboot.web.report;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.carshopboot.model.Report;
import org.ikropachev.carshopboot.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = ReportController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Report controller", description = "Operations for reports")
public class ReportController {
    static final String REST_URL = "/api/reports";
    protected static final String DATE_BEGIN_STR = "2021-10-02";
    protected static final String DATE_END_STR = "2021-10-03";

    @Autowired
    private ReportRepository reportRepository;

    //controller for visual test
    @GetMapping
    @Operation(summary = "View a list of all reports")
    public List<Report> getAll() {
        log.info("get all genres");
        return reportRepository.getAll();
    }

    @GetMapping(value = "/by-period/{beginDate}/{startDate}")
    @Operation(summary = "View a revenue by period")
    public Integer getRevenueByPeriod(@Nullable @RequestParam(value = "beginDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                      @Parameter(example = DATE_BEGIN_STR, required = false)
                                      LocalDate beginDate,
                                      @Nullable @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                      @Parameter(example = DATE_END_STR, required = false)
                                      LocalDate endDate) {
        log.info("get revenue by period from {} to {}", beginDate, endDate);
        return reportRepository.getRevenueByPeriod(beginDate, endDate);
    }
}
