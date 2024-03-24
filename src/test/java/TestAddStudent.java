package tests;

import org.junit.jupiter.api.*;

import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddStudent {
    private Service service;
    private StudentXMLRepository studentXMLRepository;
    private TemaXMLRepository temaXmlRepo;
    private NotaXMLRepository notaXmlRepo;

    @BeforeEach
    void setup() {
        this.studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        this.temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        this.notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        this.service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);
    }

    @Test
    public void emptyLineId() {
        // Arrange
        String id = "";
        String nume = "Andrei";
        int grupa = 936;

        // Act
        int result = service.saveStudent(id, nume, grupa);

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void emptyLineName() {
        // Arrange
        String id = "0";
        String nume = "";
        int grupa = 936;

        // Act
        int result = service.saveStudent(id, nume, grupa);

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void groupRange() {
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

    @Test
    public void sameId() {
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

    @Test
    public void goodEntity() {
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
