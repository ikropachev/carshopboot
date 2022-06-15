package org.ikropachev.carshopboot.web.report;

import org.ikropachev.carshopboot.MatcherFactory;
import org.ikropachev.carshopboot.model.Car;
import org.ikropachev.carshopboot.model.Client;
import org.ikropachev.carshopboot.model.Report;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportTestData {
    public static final MatcherFactory.Matcher<Report> REPORT_MATCHER =
            MatcherFactory.usingEqualsComparator(Report.class);

    public static final MatcherFactory.Matcher<Report> REVENUE_MATCHER =
            MatcherFactory.usingIgnoringFieldsComparator(Report.class, "id", "date", "car", "numberOfSales", "client");

    public static final String REPORT_STR = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"date\": \"2021-10-01\",\n" +
            "    \"car\": {\n" +
            "      \"id\": 1,\n" +
            "      \"name\": \"BMW X5\"\n" +
            "    },\n" +
            "    \"numberOfSales\": 1,\n" +
            "    \"revenue\": 2000000,\n" +
            "    \"client\": {\n" +
            "      \"id\": 1,\n" +
            "      \"name\": \"Иванов Сергей\",\n" +
            "      \"phone\": \"+79107891122\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"date\": \"2021-10-02\",\n" +
            "    \"car\": {\n" +
            "      \"id\": 3,\n" +
            "      \"name\": \"BMW X7\"\n" +
            "    },\n" +
            "    \"numberOfSales\": 1,\n" +
            "    \"revenue\": 2000000,\n" +
            "    \"client\": {\n" +
            "      \"id\": 2,\n" +
            "      \"name\": \"Коробкин Олег\",\n" +
            "      \"phone\": \"+79107891155\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"date\": \"2021-10-02\",\n" +
            "    \"car\": {\n" +
            "      \"id\": 1,\n" +
            "      \"name\": \"BMW X5\"\n" +
            "    },\n" +
            "    \"numberOfSales\": 2,\n" +
            "    \"revenue\": 2000000,\n" +
            "    \"client\": {\n" +
            "      \"id\": 2,\n" +
            "      \"name\": \"Коробкин Олег\",\n" +
            "      \"phone\": \"+79107891155\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"date\": \"2021-10-02\",\n" +
            "    \"car\": {\n" +
            "      \"id\": 2,\n" +
            "      \"name\": \"BMW X6\"\n" +
            "    },\n" +
            "    \"numberOfSales\": 2,\n" +
            "    \"revenue\": 3500000,\n" +
            "    \"client\": {\n" +
            "      \"id\": 2,\n" +
            "      \"name\": \"Коробкин Олег\",\n" +
            "      \"phone\": \"+79107891155\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"date\": \"2021-10-02\",\n" +
            "    \"car\": {\n" +
            "      \"id\": 3,\n" +
            "      \"name\": \"BMW X7\"\n" +
            "    },\n" +
            "    \"numberOfSales\": 1,\n" +
            "    \"revenue\": 2000000,\n" +
            "    \"client\": {\n" +
            "      \"id\": 3,\n" +
            "      \"name\": \"Олейкин Роман\",\n" +
            "      \"phone\": \"+79107891166\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"date\": \"2021-10-03\",\n" +
            "    \"car\": {\n" +
            "      \"id\": 2,\n" +
            "      \"name\": \"BMW X6\"\n" +
            "    },\n" +
            "    \"numberOfSales\": 1,\n" +
            "    \"revenue\": 3000000,\n" +
            "    \"client\": {\n" +
            "      \"id\": 1,\n" +
            "      \"name\": \"Иванов Сергей\",\n" +
            "      \"phone\": \"+79107891122\"\n" +
            "    }\n" +
            "  }\n" +
            "]";

    public static final int REPORT1_ID = 1;
    public static final int CAR1_ID = 1;
    public static final int CLIENT1_ID = 1;

    public static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final LocalDate date1 = LocalDate.parse("2021-12-01", PATTERN);
    public static final LocalDate date2 = LocalDate.parse("2021-12-02", PATTERN);
    public static final LocalDate date3 = LocalDate.parse("2021-12-03", PATTERN);

    public static final Car car1 = new Car(CAR1_ID, "BMW X5");
    public static final Car car2 = new Car(CAR1_ID + 1, "BMW X6");
    public static final Car car3 = new Car(CAR1_ID + 2, "BMW X7");

    public static final Client client1 = new Client(CLIENT1_ID, "Иванов Сергей", "+79107891122");
    public static final Client client2 = new Client(CLIENT1_ID + 1, " Коробкин Олег", "+79107891155");
    public static final Client client3 = new Client(CLIENT1_ID + 2, " Олейкин Роман", "+79107891166");

    public static final Report report1 = new Report(REPORT1_ID, date1, car1, 1, 2000000, client1);
    public static final Report report2 = new Report(REPORT1_ID + 1, date2, car2, 2, 3500000, client2);
    public static final Report report3 = new Report(REPORT1_ID + 2, date2, car3, 1, 2000000, client3);
    public static final Report report4 = new Report(REPORT1_ID + 3, date2, car3, 1, 2000000, client2);
    public static final Report report5 = new Report(REPORT1_ID + 4, date2, car1, 2, 2000000, client2);
    public static final Report report6 = new Report(REPORT1_ID +5, date3, car2, 1, 3000000, client1);

    public static final List<Report> reportsSorted = List.of(report1, report4, report5, report2, report3, report6);

    public static final Report revenueReport = new Report(REPORT1_ID, date1, car1, 1, 12500000, client1);
}
