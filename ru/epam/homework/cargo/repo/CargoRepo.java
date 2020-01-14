package ru.epam.homework.cargo.repo;

import ru.epam.homework.cargo.domain.Cargo;
import ru.epam.homework.cargo.search.CargoSearchCondition;
import ru.epam.homework.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

  Cargo getByIdFetchingTransportations(long id);

  Cargo[] findByName(String name);

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
