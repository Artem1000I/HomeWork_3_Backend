package HomeWork3;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class GetAndRestSpoonacular extends AbstractTestSpoonacular{


//Автоматизируйте GET /recepies/complexSearch (минимум 5 кейсов) и POST /recipes/cuisine (минимум 5 кейсов), используя rest-assured.
    @Test
    void getRecipePastaTest() {
          given() //другой способ определяем наши queryParam в блоке given
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("maxFat",20)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                  .assertThat()
                  //.cookie("cookieName", "cookieValue")
                  .statusCode(200)
                  .statusLine("HTTP/1.1 200 OK")
                  .statusLine(containsString("OK"))
                  .header("Connection", "keep-alive")
                  .header("Content-Length", Integer::parseInt, lessThan(3000))
                  .contentType(ContentType.JSON)
                  //  .body(equalTo("something"))
                  .time(lessThan(2000L)); //проверяем время выполнения запроса
    }
    @Test
    void getRecipePotatoTest() {
        given() //другой способ определяем наши queryParam в блоке given
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "Potato")
                .queryParam("maxFat",20)
                .queryParam("minCalories",50)
                .queryParam("maxFat",20)
                .queryParam("id",1697549)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса
    }

    @Test
    void getRecipeRicePuddingTest() {
        given() //другой способ определяем наши queryParam в блоке given
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "Rice Pudding")
                .queryParam("maxFat",20)
                .queryParam("minCalories",50)
                .queryParam("maxFat",20)
                .queryParam("id",658276)
                .queryParam("minCarbs",10)
                .queryParam("minProtein",10)
                .queryParam("minCalories",50)
                .queryParam("minFat",10)
                .queryParam("maxAlcohol",100)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса
    }
    @Test
    void getRecipePearTest() {
        given() //другой способ определяем наши queryParam в блоке given
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "Pear")
                .queryParam("maxFat",50)
                .queryParam("minCalories",60)
                .queryParam("maxFat",50)
                .queryParam("id",655424)
                .queryParam("minCarbs",50)
                .queryParam("minProtein",50)
                .queryParam("minCalories",50)
                .queryParam("minFat",50)
                .queryParam("maxAlcohol",50)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса
    }
    @Test
    void getRecipeSoupTest() {
        given() //предусловие
                .when() //действие вызов ресурса создание и передача http
                .get(getBaseUrl() + "recipes/complexSearch?" + //с помощьюу конкотенации строк  к базовому url getBaseUrl добовляяем строки чтобы сформировать запрос
                        "query=Soup&apiKey=" + getApiKey()) //добавляем ключ
                .then() //в блоке then тестируем результат
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса
    }

  //POST------------------------------------------------------------------------------
    @Test
    void postCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded") //добавляем контент тайп как в 2задании добавляем title
                .formParam("title","Pork roast with green beans")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса
    }
    @Test
    void postCuisineBurgerTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded") //добавляем контент тайп как в 2задании добавляем title
                .formParam("title","burger")
                .expect()

                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса
    }
    @Test
    void postCuisineSushiTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded") //добавляем контент тайп как в 2задании добавляем title
                .formParam("title","Sushi")
                .expect()

                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса
    }
    @Test
    void postCuisineMacaroniTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded") //добавляем контент тайп как в 2задании добавляем title
                .formParam("title","Macaroni")
                .expect()

                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса
    }
    @Test
    void postCuisinePizzaTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded") //добавляем контент тайп как в 2задании добавляем title
                .formParam("title","Pizza")
                .expect()

                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса
    }


//2. Сделать автоматизацию цепочки (хотя бы 1 тест со всеми эндпоинтами) для создания и удаления блюда в MealPlan). Подумайте, как использовать tearDown при тестировании POST /mealplanner/:username/shopping-list/items
    @Test
    void getMealPlanTest() { //получили план питания
        given() //предусловие
                .when() //действие вызов ресурса создание и передача http
                .get(getBaseUrl() + "mealplanner/generate?" + //с помощьюу конкотенации строк  к базовому url getBaseUrl добовляяем строки чтобы сформировать запрос
                        "timeFrame=day\n" +
                        "&targetCalories=9000&diet=vegetarian&exclude=shellfish&apiKey=" + getApiKey()) //добавляем ключ
                .then() //в блоке then тестируем результат
                .statusCode(200); //проверяем на статус код
    }
    @Test
    void getMealPlanEatTest() { //получили план питания на 5 дней для вегетеринцев
        given() //предусловие
                .when() //действие вызов ресурса создание и передача http
                .get(getBaseUrl() + "mealplanner/generate?" + //с помощьюу конкотенации строк  к базовому url getBaseUrl добовляяем строки чтобы сформировать запрос
                        "timeFrame=5&targetCalories=2000&diet=vegetarian&apiKey=" + getApiKey()) //добавляем ключ
                .then() //в блоке then тестируем результат
                .statusCode(200); //проверяем на статус код
    }

    //Meal Planning
    @Test
    void addMealTest() {
        String id = given()
                .queryParam("hash", "ef1938d7ad11581702734aa757552e1126f073f8")
                .queryParam("apiKey", getApiKey())
                .body("{\n"
                        + " \"item\": \"1 package baking powder\",\n"
                        + " \"aisle\": \"Baking\",\n"
                        + " \"parse\": true,\n"
                        + "}")
                .when()
                .post(getBaseUrl() + "mealplanner/your-users-name638/shopping-list/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();
        System.out.println(id);

    }

@Test
//Получить список покупок
        void shoppingListTest(){
        given() //предусловие
                .when() //действие вызов ресурса создание и передача http
                .get(getBaseUrl() + "mealplanner/your-users-name638/shopping-list?" + //с помощьюу конкотенации строк  к базовому url getBaseUrl добовляяем строки чтобы сформировать запрос
                        "hash=ef1938d7ad11581702734aa757552e1126f073f8&apiKey=" + getApiKey()) //добавляем ключ
                .then() //в блоке then тестируем результат
                .statusCode(200); //проверяем на статус код

        }
@Test
   void delitiShopingList() {
        given()
                .queryParam("hash", "ef1938d7ad11581702734aa757552e1126f073f8")
                .queryParam("apiKey", getApiKey())
                .expect()
                .when()
                .post(getBaseUrl()+"mealplanner/your-users-name638/shopping-list/items/1409229")
                .then()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", "keep-alive")
                .header("Content-Length", Integer::parseInt, lessThan(3000))
                .contentType(ContentType.JSON)
                //  .body(equalTo("something"))
                .time(lessThan(2000L)); //проверяем время выполнения запроса

}



}
