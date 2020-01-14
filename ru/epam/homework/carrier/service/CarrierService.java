package ru.epam.homework.carrier.service;

import ru.epam.homework.carrier.domain.Carrier;
import ru.epam.homework.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

  Carrier getByIdFetchingTransportations(Long id);

  List<Carrier> findByName(String name);

}
