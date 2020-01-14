package ru.epam.homework.cargo.service;

import ru.epam.homework.cargo.domain.Cargo;
import ru.epam.homework.cargo.search.CargoSearchCondition;
import ru.epam.homework.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService<Cargo, Long> {

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
