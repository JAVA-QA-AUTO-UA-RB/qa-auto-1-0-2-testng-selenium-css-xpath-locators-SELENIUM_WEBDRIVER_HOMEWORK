### README_TEST.md

# Проєкт Selenium TestNG
Цей проєкт містить тести Selenium WebDriver з використанням фреймворку TestNG. Тести охоплюють різні сценарії, такі як перевірка вибору чекбоксів, опцій випадаючих списків та взаємодія з веб-елементами, такими як слайдери та функції перетягування.

## Попередні вимоги
Перед запуском тестів переконайтеся, що у вас встановлено наступне програмне забезпечення:

- **Java Development Kit (JDK) 8 або пізніший**: Ви можете завантажити його [тут](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Apache Maven**: Потрібний для збірки та запуску проєкту. Ви можете завантажити його [тут](https://maven.apache.org/download.cgi).
- **Google Chrome**(Або інші): Браузер, в якому будуть виконуватись тести.
- **ChromeDriver**(driver для вашого браузера): WebDriver для Google Chrome. Завантажте версію, яка відповідає вашій версії Chrome [тут](https://sites.google.com/a/chromium.org/chromedriver/downloads) і додайте шлях до нього у змінну середовища PATH вашої системи.

## Структура проєкту
- **src/test/java/**: Містить класи тестів.
- **pom.xml**: Конфігураційний файл Maven.
- **README_TEST.md**: Цей файл.

## Як запустити тести
### Крок 1: Клонуйте репозиторій
Якщо ви ще цього не зробили, склонуйте репозиторій на ваш локальний комп'ютер:

git clone <repository-url>
cd <repository-directory>

### Крок 2: Запустіть тести за допомогою Maven
Використовуйте наступну команду для запуску тестів:

mvn test

### Приклад виводу в консолі
Коли тести успішно пройдуть, ви повинні побачити вивід, подібний до наступного:

[INFO] Scanning for projects...
[INFO]
[INFO] ----------------< org.example:SELENIUM_TESTNG_HOMEWORK >----------------
[INFO] Building SELENIUM_TESTNG_HOMEWORK 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ SELENIUM_TESTNG_HOMEWORK ---
[INFO] skip non existing resourceDirectory C:\Users\aleks\Documents\GitHub\QA_Auto_Homework_1_Aleks_C\2-testng-selenium-css-xpath-locators-AleksChernysh\src\main\resources
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ SELENIUM_TESTNG_HOMEWORK ---
[INFO] Nothing to compile - all classes are up to date.
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ SELENIUM_TESTNG_HOMEWORK ---
[INFO] skip non existing resourceDirectory C:\Users\aleks\Documents\GitHub\QA_Auto_Homework_1_Aleks_C\2-testng-selenium-css-xpath-locators-AleksChernysh\src\test\resources
[INFO]
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ SELENIUM_TESTNG_HOMEWORK ---
[INFO] Nothing to compile - all classes are up to date.
[INFO]
[INFO] --- surefire:3.2.5:test (default-test) @ SELENIUM_TESTNG_HOMEWORK ---
[INFO] Using auto detected provider org.apache.maven.surefire.testng.TestNGProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 8.859 s -- in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  13.945 s
[INFO] Finished at: 2024-09-01T20:34:40+03:00

[INFO] ------------------------------------------------------------------------
```

### Крок 3: Перегляньте результати тестів
Якщо якийсь тест не пройде, вивід у консолі покаже деталі помилки, включаючи очікувані та фактичні результати, а також стек трасування помилки. Ви можете знайти детальний звіт про тести в каталозі `target/surefire-reports`.

### Налаштування тестів
- **Зміна URL**: Якщо ви хочете запускати тести на іншому URL, оновіть виклики `browser.get("https://the-internet.herokuapp.com/")` у методах тестів.
- **Зміна WebDriver**: Якщо ви хочете використовувати інший WebDriver (наприклад, Firefox, Edge), оновіть метод `setUp()` у класі тесту.

### Висновок
Цей проєкт демонструє використання Selenium WebDriver з TestNG для автоматизації тестування веб-застосунків. Виконуючи кроки, описані в цьому документі, ви зможете легко запустити тести та перевірити їх успішне виконання.
