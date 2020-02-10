package ru.epam.homework.aa_sax;


import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.util.List;

import static ru.epam.homework.aa_sax.SaxCommonParser.*;
import static ru.epam.homework.storage.Storage.*;

public class MyStartHandler extends DefaultHandler {
 /*   File file;

    public MyStartHandler() {
        file = SaxCommonParser.file;
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        if (qName.equals("cargoTransport")) {
            MyHandlerTransportation handler = new MyHandlerTransportation();
            saxParser.parse(file, handler);
            transportationCollection.addAll(handler.getList());
        }

        if (qName.equals("carrier")) {
            MyHandlerCarrier handler = new MyHandlerCarrier();
            saxParser.parse(file, handler);
            carrierCollection.addAll(handler.getList());
        }

        if (qName.equals("clothersCargo")) {
            MyHandlerClothersCargo handler = new MyHandlerClothersCargo();
            saxParser.parse(file, handler);
            cargoClothCollection.addAll(handler.getList());
        }

        if (qName.equals("foodcargo")) {
            MyHandlerFoodCargo handler = new MyHandlerFoodCargo();
            saxParser.parse(file, handler);
            cargoFoodCollection.addAll(handler.getList());
        }
    }

    @Override
    public void endElement(String s, String s1, String qName) {
    }

    @Override
    public List getList() {
        return null;
    }*/
}
