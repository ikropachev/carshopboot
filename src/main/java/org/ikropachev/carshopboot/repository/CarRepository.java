package org.ikropachev.carshopboot.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.carshopboot.model.Car;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Tag(name = "Car Controller")
public interface CarRepository extends BaseRepository<Car> {
}
