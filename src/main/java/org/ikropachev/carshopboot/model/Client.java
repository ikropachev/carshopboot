package org.ikropachev.carshopboot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Client extends NamedEntity {
    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "phone", nullable = false)
    @Schema(example = "phone")
    protected String phone;

    public Client(Integer id, String name, String phone) {
        super(id, name);
        this.name = name;
        this.phone = phone;
    }
}
