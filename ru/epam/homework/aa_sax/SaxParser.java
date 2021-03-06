package ru.epam.homework.aa_sax;

import ru.epam.homework.cargo.domain.ClothersCargo;
import ru.epam.homework.cargo.domain.FoodCargo;
import ru.epam.homework.carrier.domain.Carrier;
import ru.epam.homework.common.business.domain.BaseEntity;
import ru.epam.homework.transportation.domain.Transportation;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SaxParser {

    public static void main(String[] args) throws Exception, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        List<Carrier> carList = parseAndPrint("D:\\IdeaProjects\\dimdim\\src\\Carrier.xml", saxParser, new MyHandlerCarrier());
        List<TransportationEnhanced> trEnhList = parseAndPrint("D:\\IdeaProjects\\dimdim\\src\\CargoTransportation.xml", saxParser, new MyHandlerTransportation());
        List<FoodCargo> foodCList = parseAndPrint("D:\\IdeaProjects\\dimdim\\src\\FoodCargo.xml", saxParser, new MyHandlerFoodCargo());
        List<ClothersCargo> cloCList = parseAndPrint("D:\\IdeaProjects\\dimdim\\src\\ClothersCargo.xml", saxParser, new MyHandlerClothersCargo());
        foolExchange(trEnhList, foodCList, cloCList, carList);
        for (int i = 0; i < trEnhList.size(); i++) {
            System.out.println(trEnhList.get(i).getCargo().getId() + "   " + trEnhList.get(i).getCargo().getCargoType());
            System.out.println(trEnhList.get(i).getCargo().getTransportations().toString());
            System.out.println(trEnhList.get(i).getCarrier().getId() + "   " + trEnhList.get(i).getCarrier().getCarrierType());
            System.out.println(trEnhList.get(i).getCarrier().getTransportations().toString());
            System.out.println();
        }
    }

    public static void foolExchange(List<TransportationEnhanced> trEnhList,
                                    List<FoodCargo> foodCList, List<ClothersCargo> cloCList, List<Carrier> carList) {
        FoodCargo food = null;
        ClothersCargo cloth = null;
        Carrier carr = null;
//        List<Transportation> tmpList = new ArrayList<>();
        for (TransportationEnhanced transportation : trEnhList) {
            long idTmp;

            idTmp = transportation.getCargoId();

            Optional<FoodCargo> foodCargoOptional = Optional.of(getById(foodCList, idTmp));
            if (foodCargoOptional.isPresent()) {
                food=foodCargoOptional.get();
                transportation.setCargo(food);
                if (food.getTransportations() == null)
                    food.setTransportations(new ArrayList<Transportation>());
                food.getTransportations().add(transportation);
            }

            food = getById(foodCList, idTmp);
            if (food != null) {
                transportation.setCargo(food);
                if (food.getTransportations() == null)
                    food.setTransportations(new ArrayList<Transportation>());
                food.getTransportations().add(transportation);
            } else {
                cloth = getById(cloCList, idTmp);
                if (cloth != null) {
                    transportation.setCargo(cloth);
                    if (cloth.getTransportations() == null)
                        cloth.setTransportations(new ArrayList<Transportation>());
                    cloth.getTransportations().add(transportation);
                }
            }
            idTmp = transportation.getCarrierId();
            carr = getById(carList, idTmp);
            if (carr != null) {
                transportation.setCarrier(carr);
                if (carr.getTransportations() == null)
                    carr.setTransportations(new ArrayList<Transportation>());
                carr.getTransportations().add(transportation);
            }
        }

    }

    public static <P extends BaseEntity> P getById(List<P> list, long id) {
        P p = null;
        for (int i = 0; i < list.size(); i++) {
            p = list.get(i);
            if (p.getId().equals(id))
                return p;
        }
        return null;
    }

    public static <H extends MyDefHandler, P>
    List<P> parseAndPrint(String filePath, SAXParser saxParser, H handler) throws IOException, SAXException {
        File file = new File(filePath);
        saxParser.parse(file, handler);
        List<P> list = handler.getList();
        for (P element : list) {
            System.out.println(element.toString());
        }
        return list;
    }
}
