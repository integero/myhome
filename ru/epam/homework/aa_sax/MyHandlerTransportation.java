package ru.epam.homework.aa_sax;

import ru.epam.homework.common.solutions.utils.JavaUtilDataUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MyHandlerTransportation extends MyDefHandler {
    private List<TransportationEnhanced> transportationList = new ArrayList<>();
    private TransportationEnhanced transportation = null;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        stringBuilder.setLength(0);
        if (qName.equals("transportation"))
            transportation = new TransportationEnhanced();
    }

    @Override
    public void endElement(String s, String s1, String qName) {
        String data = stringBuilder.toString();
        switch (qName) {
            case "transportation": {
                transportationList.add(transportation);
                break;
            }
            case "id": {
                transportation.setId((long) Integer.parseInt(data));
                break;
            }
            case "cargoId": {
                transportation.setCargoId((long) Integer.parseInt(data));
                break;
            }
            case "carrierId": {
                transportation.setCarrierId((long) Integer.parseInt(data));
                break;
            }
            case "description": {
                transportation.setDescription(data);
                break;
            }
            case "billTo": {
                transportation.setBillTo(data);
                break;
            }
            case "transportationBeginDate": {
                try {
                    transportation.setTransportationBeginDate(JavaUtilDataUtils.valueOf(data));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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
    public List<TransportationEnhanced> getList() {
        return transportationList;
    }
}

