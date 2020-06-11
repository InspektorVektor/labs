package XmlManagers;

import Exceptions.FileNotFoundException;
import App.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.File;

/**
 * Класс - сохранщик
 */
public class XmlSaver {

    /**
     * Метод для сохранения коллекции в файл
     * @param c коллекция
     * @param path путь до файла
     * @throws java.io.FileNotFoundException
     */
    public static void saveCollection(Collection c, String path) throws java.io.FileNotFoundException{

        try{
            File newCollection = new File(path);
            if (!newCollection.exists()) throw new FileNotFoundException();
            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(newCollection));
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(c, outputStreamWriter);
        }catch (JAXBException e){
            System.out.println("Некорректный файл");
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
