package org.ikropachev.carshopboot.web.report;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ikropachev.carshopboot.repository.ReportRepository;
import org.ikropachev.carshopboot.util.JsonUtil;
import org.ikropachev.carshopboot.web.AbstractControllerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.ikropachev.carshopboot.web.report.ReportController.DATE_BEGIN_STR;
import static org.ikropachev.carshopboot.web.report.ReportController.DATE_END_STR;
import static org.ikropachev.carshopboot.web.report.ReportTestData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReportControllerTest extends AbstractControllerTest {
    private static final String REST_URL = ReportController.REST_URL;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private void setMapper(ObjectMapper objectMapper) {
        JsonUtil.setMapper(objectMapper);
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(REPORT_MATCHER.contentJson(reportsSorted));
    }

    @Test
    void getRevenueByPeriod() throws Exception {
        perform(MockMvcRequestBuilders.get("/api/reports/revenue/by-period/2021-10-02/2021-10-03?beginDate=2021-10-02&endDate=2021-10-03"))
                .andExpect(status().isOk())
                .andDo(print())
                // https://jira.spring.io/browse/SPR-14472
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("12500000"));
    }
}
