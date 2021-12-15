package ru.sfedu.Kursovaya.api.DataProviders;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Kursovaya.Beans.*;
import ru.sfedu.Kursovaya.UtilBeans.HistoryContent;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDataProvider  {
    private final MongoDBDataProvider mdvdp=new MongoDBDataProvider();
    public AbstractDataProvider() throws IOException {}

    public void saveToLog(HistoryContent historyContent,String string) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        mdvdp.insertRecord(historyContent,string);
    }

    /**
     * Create game,resources,army
     * @param game Game
     * @param resources Resources
     * @param army Army
     * @return Game
     */
    public abstract Game createUniverse(Game game,Resources resources,Army army) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException, SQLException;

    /**
     * Remove game,resources,army from file
     * @param id Long
     * @return Boolean
     */
    public abstract Boolean deleteUniverse(Long id) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException;

    /**
     * Get enemy planet by id
     * @param planetId Long
     * @param gameId Long
     * @return EnemyPlanet
     */
    public abstract EnemyPlanet getEnemyPower(Long planetId, Long gameId) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;

    /**
     * Get army info by id
     * @param gameId Long
     * @return ArmyInfo
     */
    public abstract ArmyInfo getArmyPower(Long gameId) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException;

    /**
     * Attack planet by id
     * if your army dies: you will lose and all data will be deleted
     * if you win: enemy planet will become yours
     * @param enemyPlanetId Long
     * @param gameId Long
     * @return Boolean
     */
    public abstract Boolean attackPlanet(Long enemyPlanetId,Long gameId) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException, SQLException;

    /**
     * Add unit from file to army unit list
     * @param unitId Long
     * @param gameId Long
     * @return Game
     */
    public abstract Game hireUnit(Long unitId, Long gameId) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException, SQLException;

    /**
     * Get building list
     * @param gameId Long
     * @return List<Building>
     */
    public abstract List<Building> getBuildingsInfo(Long gameId) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;

    /**
     * Add building from file to resources building list
     * @param buildingId Long
     * @param gameId Long
     * @return Game
     */
    public abstract Game addBuilding(Long buildingId,Long gameId) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException, SQLException;

    /**
     * Remove building from resources building list
     * @param buildingId long
     * @param gameId Long
     * @return Game
     */
    public abstract Game removeBuilding(Long buildingId,Long gameId) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException, SQLException;

    /**
     * If
     * operation==2 -> Add building from file to resources building list
     * operation==3 -> Remove building from resources building list
     * operation==4 -> Add unit from file to army unit list
     * And update game,resources,army
     * @param gameId Long
     * @param operation int
     * @param id Long
     * @return Game
     */
    public abstract Game manageResources(Long gameId,int operation,Long id) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException, SQLException;

    /**
     * If
     * operation==1 -> Get building list
     * @param gameId Long
     * @param operation int
     * @return Game
     */
    public abstract Game manageResources(Long gameId,int operation) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException, SQLException;

    /**
     * Get building from file by id
     * @param id Long
     * @return Game
     */
    public abstract Building getBuildingById(Long id) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException, SQLException;

    /**
     * Get unit from file by id
     * @param id Long
     * @return Game
     */
    public abstract Unit getUnitById(Long id) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, JAXBException, SQLException;
}
