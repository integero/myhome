package ru.epam.homework.aa_sax;


import ru.epam.homework.cargo.domain.ClothersCargo;

import java.util.ArrayList;
import java.util.List;

public class MyHandlerClothersCargo extends MyDefHandler {
 private List<ClothersCargo> clotherCargoList=new ArrayList<>();
private ClothersCargo clothersCargo =null;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        stringBuilder.setLength(0);
        if (qName.equals("cargo"))
            clothersCargo = new ClothersCargo();
    }

    @Override
    public void endElement(String s, String s1, String qName) {
        String data = stringBuilder.toString();
        switch (qName) {
            case "cargo": {
                clotherCargoList.add(clothersCargo);
                break;
            }
            case "id": {
                clothersCargo.setId((long)Integer.parseInt(data));
                break;
            }
            case "name": {
                clothersCargo.setName(data);
                break;
            }

            case "weight": {
                clothersCargo.setWeight(Integer.parseInt(data));
                break;
            }
            case "material": {
                clothersCargo.setMaterial(data);
                break;
            }
            case "size": {
                clothersCargo.setSize(data);
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
    public List<ClothersCargo> getList() {
        return clotherCargoList;
    }
}
