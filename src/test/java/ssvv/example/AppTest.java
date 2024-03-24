package ssvv.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testEmptyLineId() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        // Arrange
        String id = "";
        String nume = "Andrei";
        int grupa = 936;

        // Act
        int result = service.saveStudent(id, nume, grupa);

        // Assert
        assertEquals(1, result);
    }

    public void testEmptyLineName() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        // Arrange
        String id = "0";
        String nume = "";
        int grupa = 936;

        // Act
        int result = service.saveStudent(id, nume, grupa);

        // Assert
        assertEquals(1, result);
    }

    public void testGroupRange() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        // Arrange
        String nume = "Andrei";
        int groupOk = 936;
        int groupLess = 1;
        int groupMore = 1000;

        // Act
        int resultsuccess = service.saveStudent("10", nume, groupOk);
        int resultFailLess = service.saveStudent("11", nume, groupLess);
        int resultFailmore = service.saveStudent("12", nume, groupMore);

        // Assert
        assertEquals(0, resultsuccess);
        assertEquals(1, resultFailLess);
        assertEquals(1, resultFailmore);
    }

    public void testSameId() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        // Arrange
        String id = "20";
        String nume = "Andrei";
        int grupa = 936;

        // Act
        int resultSuccess = service.saveStudent(id, nume, grupa);
        int resultFail = service.saveStudent(id, nume, grupa);

        // Assert
        assertEquals(0, resultSuccess);
        assertEquals(1, resultFail);
    }

    public void testGoodEntity() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        // Arrange
        String id = "0";
        String nume = "Andrei Pop Fabian";
        int grupa = 936;

        // Act
        int resultSuccess = service.saveStudent(id, nume, grupa);

        // Assert
        assertEquals(0, resultSuccess);
    }
}
