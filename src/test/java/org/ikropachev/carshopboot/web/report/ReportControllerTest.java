package org.ikropachev.carshopboot.web.report;

import org.ikropachev.carshopboot.repository.ReportRepository;
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

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(REPORT_MATCHER.contentJson(reportsSorted));
    }

    @Test
    void getRevenueByPeriod() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/by-period/" + DATE_BEGIN_STR + "/" + DATE_END_STR))
                .andExpect(status().isOk())
                .andDo(print())
                // https://jira.spring.io/browse/SPR-14472
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(REVENUE_MATCHER.contentJson(revenueReport));
    }
}