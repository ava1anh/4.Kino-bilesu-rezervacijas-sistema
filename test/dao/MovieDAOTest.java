package dao;

import static org.junit.Assert.*;
import java.util.List;
import model.Movie;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import util.TestDb;

/**
 * MovieDAO testi: filmu CRUD darbības un meklēšana.
 */
public class MovieDAOTest {

    private final MovieDAO dao = new MovieDAO();
    private int movieId = -1;

    @BeforeClass
    public static void setUpClass() {
        TestDb.setUp();
    }

    @After
    public void tearDown() {
        if (movieId > 0) {
            dao.deleteMovie(movieId);
            movieId = -1;
        }
    }

    @Test
    public void testAddAndFind() {
        movieId = dao.addMovie(new Movie("Testa filma XYZ", "Trilleris", 111, "Apraksts"));
        assertTrue(movieId > 0);
        Movie m = dao.findById(movieId);
        assertEquals("Testa filma XYZ", m.getTitle());
        assertEquals(111, m.getDurationMin());
    }

    @Test
    public void testSearchByTitleAndGenreIgnoringCase() {
        movieId = dao.addMovie(new Movie("Testa filma XYZ", "Trilleris", 111, "Apraksts"));
        List<Movie> byTitle = dao.search("filma xyz");
        assertEquals(1, byTitle.size());
        assertEquals(movieId, byTitle.get(0).getId());
        assertEquals(1, dao.search("TRILL").size());
        assertTrue(dao.search("nav_tada_filma_999").isEmpty());
    }

    @Test
    public void testUpdate() {
        movieId = dao.addMovie(new Movie("Testa filma XYZ", "Trilleris", 111, "Apraksts"));
        Movie m = dao.findById(movieId);
        m.setTitle("Mainīts nosaukums");
        m.setDurationMin(90);
        assertTrue(dao.updateMovie(m));
        assertEquals("Mainīts nosaukums", dao.findById(movieId).getTitle());
        assertEquals(90, dao.findById(movieId).getDurationMin());
    }

    @Test
    public void testDelete() {
        movieId = dao.addMovie(new Movie("Testa filma XYZ", "Trilleris", 111, "Apraksts"));
        assertTrue(dao.deleteMovie(movieId));
        assertNull(dao.findById(movieId));
        movieId = -1;
    }

    /** CHECK ierobežojums: filmas ilgumam jābūt pozitīvam. */
    @Test
    public void testInvalidDurationRejected() {
        assertEquals(-1, dao.addMovie(new Movie("Slikta filma", "Drāma", -5, "x")));
    }
}
