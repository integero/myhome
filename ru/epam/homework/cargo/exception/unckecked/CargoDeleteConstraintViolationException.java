package ru.epam.homework.cargo.exception.unckecked;

import ru.epam.homework.common.business.exception.unchecked.OurCompanyUncheckedException;

public class CargoDeleteConstraintViolationException extends OurCompanyUncheckedException {

  private static final String MESSAGE = "Cant delete cargo with id '%s'. There are transportations which relates to it!";

  public CargoDeleteConstraintViolationException(String message) {
    super(message);
  }

  public CargoDeleteConstraintViolationException(long cargoId) {
    this(String.format(MESSAGE, cargoId));
  }
}
