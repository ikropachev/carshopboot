package org.ikropachev.carshopboot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car extends NamedEntity {
    public Car(Integer id, String name) {
        super(id, name);
        this.name = name;
    }
}
