package org.ikropachev.carshopboot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "report")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report extends BaseEntity {

    @NotNull
    @Column(name = "sale_on", columnDefinition = "date default now()")
    @Schema(example = "date")
    private LocalDate date;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;

    @NotNull
    @Column(name = "number_of_sales")
    @Schema(example = "1")
    private int numberOfSales;

    @NotNull
    @Column(name = "revenue")
    @Schema(example = "1000000")
    private int revenue;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Report(Integer id, LocalDate date, Car car, Integer numberOfSales, Integer revenue, Client client) {
        super(id);
        this.date = date;
        this.car = car;
        this.numberOfSales = numberOfSales;
        this.revenue = revenue;
        this.client = client;
    }
}
