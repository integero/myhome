package ru.epam.homework.aa_serialize;

import org.xml.sax.SAXException;
import ru.epam.homework.aa_sax.MyDefHandler;
import ru.epam.homework.aa_sax.MyHandlerCarrier;
import ru.epam.homework.carrier.domain.Carrier;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TryToSerielze {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
//        List<Carrier> carList = parseAndPrint("D:\\IdeaProjects\\dimdim\\src\\Carrier.xml", saxParser, new MyHandlerCarrier());

        Path file = null;
        try {
            file = Files.createTempFile("lesson14", ".txt");

            try (ObjectOutput objectOutput = new ObjectOutputStream(
                    new FileOutputStream(file.toFile()))) {
//                Animal a = new Animal(
//                        "Tiger", 300, new Country("Russia")
                List<Carrier> carList = parseAndPrint("D:\\IdeaProjects\\dimdim\\src\\Carrier.xml", saxParser, new MyHandlerCarrier());

//                );
                objectOutput.writeObject(carList);
            }
            List<Carrier> carriers = readObjectFromFile(file.toFile().getAbsolutePath());
            for (Carrier ca: carriers
                 ) {

                System.out.println("Size f List of Carriers: "+ ca.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    System.out.println(file);
                    System.out.println(file.getFileName());
                    //   Files.delete(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
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
    private static <P> P readObjectFromFile(String file) throws Exception {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            Object o = inputStream.readObject();
            return (P) o;
        }
    }

}
