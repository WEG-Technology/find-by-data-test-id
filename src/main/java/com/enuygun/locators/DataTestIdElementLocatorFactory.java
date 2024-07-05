package com.enuygun.locators;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class DataTestIdElementLocatorFactory implements ElementLocatorFactory {

    private final SearchContext searchContext;

    public DataTestIdElementLocatorFactory(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        return new DataTestIdElementLocator(searchContext, field);
    }
}