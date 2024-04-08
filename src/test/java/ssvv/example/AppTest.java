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

    public void testAddAssignment() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        // Arrange
        String id = "1";
        String descriere = "HW on Testing";
        int deadline = 10;
        int startline = 8;

        // Act
        int result = service.saveTema(id, descriere, deadline, startline);

        // Assert
        assertEquals(0, result);
    }

    public void testAddStudent() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        // Arrange
        String id = "0";
        String nume = "Andrei";
        int grupa = 936;

        // Act
        int result = service.saveStudent(id, nume, grupa);

        // Assert
        assertEquals(0, result);
    }

    public void testAddGrade() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        // Arrange
        String idStudent = "100";
        String nume = "Andrei";
        int grupa = 936;

        // Act
        int resultStudent = service.saveStudent(idStudent, nume, grupa);

        String idAssignment = "100";
        String descriere = "HW on Testing";
        int deadline = 10;
        int startline = 8;

        // Act
        int resultTema = service.saveTema(idAssignment, descriere, deadline, startline);

        // Arrange
        double nota = 5;
        int predata = 9;
        String feedback = "none";

        // Act
        int resultsuccess = service.saveNota(idStudent, idAssignment, nota, predata, feedback);

        // Assert
        assertEquals(0, resultsuccess);
    }

    public void testAddStudentGradeAssignment() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        // Arrange
        String idStudent = "100";
        String nume = "Andrei";
        int grupa = 936;

        // Act
        int resultStudent = service.saveStudent(idStudent, nume, grupa);
        assertEquals(0, resultStudent);

        String idAssignment = "100";
        String descriere = "HW on Testing";
        int deadline = 10;
        int startline = 8;

        // Act
        int resultTema = service.saveTema(idAssignment, descriere, deadline, startline);
        assertEquals(0, resultTema);

        // Arrange
        double nota = 5;
        int predata = 9;
        String feedback = "none";

        // Act
        int resultsuccess = service.saveNota(idStudent, idAssignment, nota, predata, feedback);
        assertEquals(0, resultsuccess);
    }
}
