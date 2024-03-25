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

public class AddAssignmentTest extends TestCase {
    public AddAssignmentTest( String testName )
    {
        super( testName );
    }
    public static Test suite()
    {
        return new TestSuite( AddAssignmentTest.class );
    }
    public void testEmptyId() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        String id = "";
        String description = "coverage";
        int deadline = 10;
        int startline = 0;

        int result = service.saveTema(id, description, deadline, startline);

        assertEquals(result, 1);
    }

    public void testEmptyDescription() {
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(new StudentValidator(), "");
        TemaXMLRepository temaXmlRepo = new TemaXMLRepository(new TemaValidator(), "");
        NotaXMLRepository notaXmlRepo = new NotaXMLRepository(new NotaValidator(), "");

        Service service = new Service(studentXMLRepository, temaXmlRepo, notaXmlRepo);

        String id = "10";
        String description = "";
        int deadline = 10;
        int startline = 0;

        int result = service.saveTema(id, description, deadline, startline);
        assertEquals(result, 1);
    }
}
