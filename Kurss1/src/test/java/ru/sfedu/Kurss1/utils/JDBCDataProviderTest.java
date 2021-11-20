package ru.sfedu.Kurss1.utils;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCDataProviderTest extends BaseTest {

    public JDBCDataProviderTest() throws JAXBException, IOException {
    }

    @Test
    void createTable() throws SQLException {
        j.createTable();
    }
    @Test
    void insertRecord() throws SQLException {
        initializeUnit();
        j.insertUnit(unit);
    }
    @Test
    void readJDBCUnit(){
        log.info(j.readUnitById(2L));
    }
    @Test
    void updateUnit() throws SQLException {
        initializeUnit();
        j.updateUnitById(unit);
    }
    @Test
    void deleteUnit() throws SQLException {
        j.deleteUnitById(1L);
    }

}