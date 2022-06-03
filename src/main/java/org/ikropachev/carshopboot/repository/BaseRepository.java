package org.ikropachev.carshopboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import static org.ikropachev.carshopboot.util.validation.ValidationUtil.checkModification;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Integer> {
}
