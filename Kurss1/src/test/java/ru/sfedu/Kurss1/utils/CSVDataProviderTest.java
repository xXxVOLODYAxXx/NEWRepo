package ru.sfedu.Kurss1.utils;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sfedu.Kurss1.entityBeans.Unit;

import javax.xml.bind.JAXBException;
import java.io.IOException;

class CSVDataProviderTest extends BaseTest {


    CSVDataProviderTest() throws IOException, JAXBException {}

    @Test
    void getUnitList() throws IOException {
        System.out.println(c.getUnitList());
    }

    @Test
    void createUnit() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        c.createUnit(initializeUnit());
        Assertions.assertEquals(unit,c.getUnitById(unit.getUnitId()));
        Assertions.assertNotEquals(initializeUnit(), null);
    }

    @Test
    void deleteUnitById() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        c.deleteUnitById(4L);
    }
    @Test
    void clearUnits() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        c.clearUnits();
    }
    @Test
    void getUnitById() throws IOException {
        System.out.println(c.getUnitById(3L));
    }

    @Test
    void updateUnitById() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        c.updateUnitById(initializeUnit());
    }
    @Test
    void getBuildingList() throws IOException {
        log.info(c.getBuildingList());
    }

}