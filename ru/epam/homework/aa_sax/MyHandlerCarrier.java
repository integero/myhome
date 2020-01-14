package ru.epam.homework.aa_sax;

import ru.epam.homework.carrier.domain.Carrier;
import ru.epam.homework.carrier.domain.CarrierType;

import java.util.ArrayList;
import java.util.List;

public class MyHandlerCarrier extends MyDefHandler  {
   private List<Carrier> carrierList=new ArrayList<>();
    private Carrier carrier =null;
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        stringBuilder.setLength(0);
        if (qName.equals("carrier"))
            carrier = new Carrier();
    }

    @Override
    public void endElement(String s, String s1, String qName) {
        String data = stringBuilder.toString();
        switch (qName) {
            case "carrier": {
                carrierList.add(carrier);
                break;
            }
            case "id": {
                carrier.setId((long)Integer.parseInt(data));
                break;
            }
            case "name": {
                carrier.setName(data);
                break;
            }
            case "address": {
                carrier.setAddress(data);
                break;
            }
            case "carrierType": {
                carrier.setCarrierType(CarrierType.valueOf(data));
                break;
            }
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        String data = new String(chars, start, length);
        stringBuilder.append(data);
    }
    @Override
    public List<Carrier> getList() {
        return carrierList;
    }
}
