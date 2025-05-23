package org.example.outsourcing.domain.menu.repository;

import org.example.outsourcing.domain.menu.entity.Menu;
import org.example.outsourcing.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findAllByStoreAndIsDeletedFalse(Store store);

}
