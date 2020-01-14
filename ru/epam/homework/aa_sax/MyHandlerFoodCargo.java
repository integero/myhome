package ru.epam.homework.aa_sax;

import ru.epam.homework.cargo.domain.FoodCargo;
import ru.epam.homework.common.solutions.utils.JavaUtilDataUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MyHandlerFoodCargo extends MyDefHandler {
    private List<FoodCargo> foodCargoList = new ArrayList<>();
    private FoodCargo foodCargo = null;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        stringBuilder.setLength(0);
        if (qName.equals("cargo"))
            foodCargo = new FoodCargo();
    }

    @Override
    public void endElement(String s, String s1, String qName) {
        String data = stringBuilder.toString();
        switch (qName) {
            case "cargo": {
                foodCargoList.add(foodCargo);
                break;
            }
            case "id": {
                foodCargo.setId((long) Integer.parseInt(data));
                break;
            }
            case "name": {
                foodCargo.setName(data);
                break;
            }
            case "weight": {
                foodCargo.setWeight(Integer.parseInt(data));
                break;
            }
            case "expirationDate": {
                try {
                    foodCargo.setExpirationDate(JavaUtilDataUtils.valueOf(data));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "storeTemperature": {
                foodCargo.setStoreTemperature(Integer.parseInt(data));
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
    public List<FoodCargo> getList() {
        return foodCargoList;
    }
}

