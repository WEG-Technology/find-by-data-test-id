package com.enuygun.locators;

import com.enuygun.annotations.FindByDataTestId;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class DataTestIdElementLocator implements ElementLocator {

    private final SearchContext searchContext;
    public final By by;

    public DataTestIdElementLocator(SearchContext searchContext, Field field) {
        this.searchContext = searchContext;
        FindByDataTestId findByDataTestId = field.getAnnotation(FindByDataTestId.class);
        if (findByDataTestId != null) {
            by = By.cssSelector(String.format("[data-testid='%s']", findByDataTestId.value()));
        } else {
            throw new IllegalArgumentException("Field must be annotated with @FindByDataTestId");
        }
    }

    @Override
    public WebElement findElement() {
        return searchContext.findElement(by);
    }

    @Override
    public java.util.List<WebElement> findElements() {
        return searchContext.findElements(by);
    }
}


