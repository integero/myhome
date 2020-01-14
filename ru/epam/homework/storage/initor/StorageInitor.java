package ru.epam.homework.storage.initor;

import ru.epam.homework.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
  void initStorage() throws InitStorageException;
}
