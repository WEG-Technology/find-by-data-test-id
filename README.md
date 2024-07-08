![](https://bugbug-homepage.s3.eu-central-1.amazonaws.com/data_testid_attributes_e8b2ed17fe.png)
![Build Status](https://img.shields.io/badge/tests-unknown-lightgrey)

# Find Element By Data Test ID

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

## Installation
#### Clone the Repository:

   ```sh
   git clone https://github.com/ercankirbiyik/findByDataTestID.git
   cd findByDataTestID
```

## Usage

1. #### Add the maven dependency and repository to your maven project:

```xml
<dependencies>
<dependency>
   <groupId>com.enuygun</groupId>
   <artifactId>findByDataTestID</artifactId>
   <version>1.1.0-SNAPSHOT</version>
</dependency>
</dependencies>
```
```xml
<repositories>
<repository>
   <id>jitpack.io</id>
   <url>https://jitpack.io</url>
</repository>
</repositories>

```
#### 2.1 Add the gradle dependency to your gradle project:

```
    dependencies {
        implementation 'com.enuygun:findByDataTestID:1.1.0-SNAPSHOT'
    }
```
      
##### 2.2 Add it in your root build.gradle at the end of repositories:
```
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
        }
    }
```

### How to use in your projects:

   ```
import com.enuygun.annotations.FindByDataTestId;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.enuygun.locators.DataTestIdElementLocatorFactory;

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

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.