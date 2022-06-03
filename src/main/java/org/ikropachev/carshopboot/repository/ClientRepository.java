package org.ikropachev.carshopboot.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.carshopboot.model.Client;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Tag(name = "Client Controller")
public interface ClientRepository extends BaseRepository<Client> {
}
