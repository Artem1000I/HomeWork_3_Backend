package HomeWork3;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTestSpoonacular {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey; //Ключ с сайта
    private static String baseUrl; //Урл сайта или ресурса

    @BeforeAll //Будет применяться для всех тестов
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/spoonacular.properties");// cчитываем конфигурационный файл
        prop.load(configFile); //загружаем его в обьект пропертис prop

        apiKey =  prop.getProperty("apiKey"); //достаем значение которое будем использовать
        baseUrl= prop.getProperty("base_url");//достаем значение которое будем использовать
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}