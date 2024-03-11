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
        this.studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "studenti.xml");
        this.temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "teme.xml");
        this.notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "note.xml");

        this.service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);
    }

    @Test
    public void test1() {
        // Arrange
        String id = "1";
        String nume = "Andrei";
        int grupa = 1;

        // Act
        int result = service.saveStudent(id, nume, grupa);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void test2() {
        // Arrange
        String id = "1";
        String nume = "Andrei";
        int grupa = 3;

        // Act
        int result = service.saveStudent(id, nume, grupa);

        // Assert
        assertEquals(1, result);
    }
}
