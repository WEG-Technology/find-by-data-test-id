# Find By Data Test ID

This project provides a custom annotation `@FindByDataTestId` to locate elements by their `data-testid` attribute using Selenium.

## Features

- Custom annotation `@FindByDataTestId` for locating elements.
- Support for modern Java and Spring Boot versions.
- Easily integrable with existing Selenium tests.
- Locator factory to streamline the usage of the annotation.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- Selenium WebDriver 4.9.0 or higher
- Spring Boot 3.1.0 or higher

### Usage

1. Add the dependency to your project:

```xml
<dependency>
   <groupId>com.example</groupId>
   <artifactId>findByDataTestID</artifactId>
   <version>1.1.0-SNAPSHOT</version>
</dependency>

<repositories>
<repository>
   <id>jitpack.io</id>
   <url>https://jitpack.io</url>
</repository>
</repositories>

```


### Installation

1. **Clone the Repository:**

   ```sh
   git clone https://github.com/ercankirbiyik/find-by-datatestid.git
   cd find-by-datatestid
    ```
   
### How to use in your projects:

   ```
import com.example.annotations.FindByDataTestId;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.example.locators.DataTestIdElementLocatorFactory;

public class HomePage {
    private WebDriver driver;

    @FindByDataTestId("login-button")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new DataTestIdElementLocatorFactory(driver), this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
   ```

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.