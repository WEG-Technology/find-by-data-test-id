package com.enuygun.locators;

import com.enuygun.annotations.FindByDataTestId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DataTestIdElementLocatorTest {

    @Mock
    private SearchContext searchContext;

    @Mock
    private WebElement webElement;

    private DataTestIdElementLocator dataTestIdElementLocator;

    @FindByDataTestId("test-id")
    private String annotatedField;

    @BeforeEach
    public void setUp() throws NoSuchFieldException {
        Field testField = this.getClass().getDeclaredField("annotatedField");
        dataTestIdElementLocator = new DataTestIdElementLocator(searchContext, testField);
    }

    @Test
    public void testFindElement() {
        when(searchContext.findElement(any(By.class))).thenReturn(webElement);
        WebElement element = dataTestIdElementLocator.findElement();
        assertNotNull(element);
        verify(searchContext).findElement(By.cssSelector("[data-testid='test-id']"));
    }

    @Test
    public void testFindElements() {
        when(searchContext.findElements(any(By.class))).thenReturn(java.util.Collections.singletonList(webElement));
        java.util.List<WebElement> elements = dataTestIdElementLocator.findElements();
        assertNotNull(elements);
        assertEquals(1, elements.size());
        verify(searchContext).findElements(By.cssSelector("[data-testid='test-id']"));
    }

    @Test
    public void testConstructorWithInvalidField() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Field invalidField = this.getClass().getDeclaredField("nonAnnotatedField");
            new DataTestIdElementLocator(searchContext, invalidField);
        });

        String expectedMessage = "Field must be annotated with @FindByDataTestId";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    private String nonAnnotatedField;
}
