package com.enuygun.locators;

import com.enuygun.annotations.FindByDataTestId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class DataTestIdElementLocatorFactoryTest {

    @Mock
    private SearchContext searchContext;

    private DataTestIdElementLocatorFactory dataTestIdElementLocatorFactory;

    @FindByDataTestId("test-id")
    private String annotatedField;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        dataTestIdElementLocatorFactory = new DataTestIdElementLocatorFactory(searchContext);
    }

    @Test
    public void testCreateLocator() throws NoSuchFieldException {
        Field field = this.getClass().getDeclaredField("annotatedField");
        ElementLocator locator = dataTestIdElementLocatorFactory.createLocator(field);
        assertNotNull(locator);
        assertTrue(locator instanceof DataTestIdElementLocator);
    }
}
