package com.videorent.business.database;

import com.videorent.business.database.config.JPAUtil;
import com.videorent.business.model.AbstractEntity;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.internal.SessionImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public abstract class AbstractDAOTest<T extends AbstractEntity> {

    protected static EntityManager entityManager;
    protected DAO<T> dao;

    private static IDatabaseConnection connection;
    private static IDataSet dataset;

    @BeforeClass
    public static void beforeAll() throws DatabaseUnitException {

        entityManager = JPAUtil.getEntityManager();
        connection = new DatabaseConnection(((SessionImpl)(entityManager.getDelegate())).connection());
        connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

        FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
        flatXmlDataSetBuilder.setColumnSensing(true);
        dataset = flatXmlDataSetBuilder.build(
                AbstractDAOTest.class.getClassLoader().getResourceAsStream("datasets/dataset.xml"));

    }

    @Before
    public void beforeEachTest() throws DatabaseUnitException, SQLException {
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);
        //DatabaseOperation.INSERT.execute(connection, dataset);
    }

    @After
    public void afterEachTest() throws DatabaseUnitException, SQLException {
        //DatabaseOperation.DELETE.execute(connection, dataset);
    }

    @AfterClass
    public static void afterAll() {
        entityManager.close();
    }

}
