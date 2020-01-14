package ru.epam.homework.common.solutions.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ru.epam.homework.cargo.domain.Cargo;
import ru.epam.homework.storage.Storage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public final class FileUtils {

    private FileUtils() {

    }

    public static File createFileFromResource(String fileNamePrefix, String fileNameSuffix, String resourcePath) throws IOException {
        try (InputStream inputStream = File.class.getResourceAsStream(resourcePath)) {
            Path tempFile = Files.createTempFile(fileNamePrefix, fileNameSuffix);
            Files.copy(inputStream, tempFile, REPLACE_EXISTING);
            return tempFile.toFile();
        }
    }


    private final String FILE_data = "data.xml";

    public static void writeDataXML() {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document doc = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.newDocument();
            Element e_root = doc.createElement("Cargo");
            doc.appendChild(e_root);
//            Element e_names = doc.createElement("name");
/*      Element e_weights = doc.createElement("weight");
      Element e_cargoTypes = doc.createElement("cargoType");
      Element e_sizes = doc.createElement("size");
      Element e_materials = doc.createElement("material");
 */
//            e_root.appendChild(e_names);
/*
      e_root.appendChild(e_weights);
      e_root.appendChild(e_cargoTypes);
      e_root.appendChild(e_sizes);
      e_root.appendChild(e_materials);
*/

            if (Storage.cargoCollection.size() == 0)
                return;
            for (int i = 0; i < Storage.cargoCollection.size(); i++) {
                Cargo cargo = Storage.cargoCollection.get(i);
                Element e_names = doc.createElement("name");
                e_names.appendChild(doc.createTextNode(cargo.getName()));
                e_root.appendChild(e_names);
            }
//------------------------------------------
/*      List<String> users  = new ArrayList<String>();
      List<String> forums = new ArrayList<String>();
      for (int i = 0; i < Storage.cargoCollection.size(); i++){
        if (!users.contains(Storage.cargoCollection.get(i).getUsername()))
          users.add(Storage.cargoCollection.get(i).getUsername());
        if (!forums.contains(Storage.cargoCollection.get(i).getForum()))
          forums.add(Storage.cargoCollection.get(i).getForum());
      }
      System.out.println("    пользователей : " +
              users.size());
      for (String user : users) {
        Element e = doc.createElement("user");
        e.setTextContent(user);
        e_users.appendChild (e);
      }
      System.out.println("    форумов : " + forums.size());
      for (String forum : forums) {
        Element e = doc.createElement("forum");
        e.setTextContent(forum);
        e_forums.appendChild (e);
      }*/
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            // Сохраняем Document в XML-файл
            if (doc != null)
                writeDocument(doc, "cargoData.xml");
        }
    }

    /**
     * Процедура сохранения DOM в файл
     */
    static private void writeDocument(Document document, String path)
            throws TransformerFactoryConfigurationError {
        Transformer trf = null;
        DOMSource src = null;
        FileOutputStream fos = null;
        try {
            trf = TransformerFactory.newInstance().newTransformer();
            trf.setOutputProperty(OutputKeys.INDENT,"yes");
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
