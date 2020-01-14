package ru.epam.homework.aa_sax;

import ru.epam.homework.transportation.domain.Transportation;

public class TransportationEnhanced extends Transportation {
    private long cargoId;
    private long carrierId;

    @Override
    public String toString() {
        return "TransportationEnhanced{" +
                "description='" + super.getDescription()+ '\'' +
                "transportationBeginDate='" + super.getTransportationBeginDate() + '\'' +
                "cargoId=" + cargoId +
                ", carrierId=" + carrierId +
                '}';
    }

    public long getCargoId() {
        return cargoId;
    }

    public void setCargoId(long cargoId) {
        this.cargoId = cargoId;
    }

    public long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(long carrierId) {
        this.carrierId = carrierId;
    }
}
