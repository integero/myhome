package ru.epam.homework.carrier.repo;

import ru.epam.homework.carrier.domain.Carrier;
import ru.epam.homework.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

  Carrier getByIdFetchingTransportations(long id);

  Carrier[] findByName(String name);

}
