package st10444823.televisonA1.prog6112;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesModelTest {

    // Runs before each test to clear the series list and ensure a clean slate.
    @BeforeEach
    public void setup() {
        SeriesModel.getSeriesList().clear();
    }
    
    // Test Case 1: TestSearchSeries() - Test if search works for an existing series
    @Test
    public void TestSearchSeries() {
        // Arrange
        SeriesModel.addSeries("S101", "Extreme Sports", "Sport", "12", "10");

        // Act
        SeriesModel result = SeriesModel.searchSeries("S101");

        // Assert
        assertNotNull(result);
        assertEquals("Extreme Sports", result.getSeriesName());
    }

    // Test Case 2: TestSearchSeries_SeriesNotFound() - Test if search handles a series that does not exist
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        // Arrange
        SeriesModel.addSeries("S101", "Extreme Sports", "Sport", "12", "10");

        // Act
        SeriesModel result = SeriesModel.searchSeries("S102");

        // Assert
        assertNull(result);
    }
    
    // Test Case 3: TestUpdateSeries() - Test to check if series details can be updated
    @Test
    public void TestUpdateSeries() {
        // Arrange
        SeriesModel.addSeries("S101", "Extreme Sports", "Sport", "12", "10");

        // Act
        SeriesModel seriesToUpdate = SeriesModel.searchSeries("S101");
        assertNotNull(seriesToUpdate);

        seriesToUpdate.setSeriesName("Extreme Sports 2025");
        seriesToUpdate.setSeriesAge("16");
        seriesToUpdate.setSeriesNumberOfEpisodes("12");

        // Assert
        assertEquals("Extreme Sports 2025", seriesToUpdate.getSeriesName());
        assertEquals("16", seriesToUpdate.getSeriesAge());
        assertEquals("12", seriesToUpdate.getSeriesNumberOfEpisodes());
    }

    // Test Case 4: TestDeleteSeries() - Test to check if a series can be deleted
    @Test
    public void TestDeleteSeries() {
        // Arrange
        SeriesModel.addSeries("S101", "Extreme Sports", "Sport", "12", "10");

        // Act
        SeriesModel.deleteSeries("S101");

        // Assert
        assertEquals(0, SeriesModel.getSeriesList().size());
        assertNull(SeriesModel.searchSeries("S101"));
    }

    // Test Case 5: TestDeleteSeries_SeriesNotFound() - Test that deleting a non-existent series doesn't affect the list
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        // Arrange
        SeriesModel.addSeries("S101", "Extreme Sports", "Sport", "12", "10");

        // Act
        SeriesModel.deleteSeries("S102");

        // Assert
        assertEquals(1, SeriesModel.getSeriesList().size());
    }

    // Test Case 6: TestSeriesAgeRestriction_AgeValid() - Test valid age restriction values
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        // Assert
        assertTrue(SeriesModel.validateAge("2"));
        assertTrue(SeriesModel.validateAge("10"));
        assertTrue(SeriesModel.validateAge("18"));
    }

    // Test Case 7: TestSeriesAgeRestriction_SeriesAgeInValid() - Test invalid age restriction values
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        // Assert
        assertFalse(SeriesModel.validateAge("1"));
        assertFalse(SeriesModel.validateAge("19"));
        assertFalse(SeriesModel.validateAge("0"));
        assertFalse(SeriesModel.validateAge("-5"));
        assertFalse(SeriesModel.validateAge("abc"));
    }
}