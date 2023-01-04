import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static final String REMOTE_SERVICE_URI = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        // Создание объекта запроса с произвольным заголовком
        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        // Отправка запроса? Response? Это же ответ
        CloseableHttpResponse response = httpClient.execute(request);

        // Вывод полученных заголовков
        Arrays.stream(response.getAllHeaders()).forEach(System.out::println);

        // Чтение тела ответа --- !!!!!! --- Почему, если раскомментировать строку 42, то программа завершается ошибкой (блок кода 45 - 49 не работает)?
//        String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);

        // Для строчки 53 добавляем код для преобразования JSON в Java
        List<Post> posts = mapper.readValue(response.getEntity().getContent(), new TypeReference<List<Post>>(){}); // Преобразовали JSON в Java
                posts.stream() // Создали поток из списка
                        .filter(post -> post.getUpvotes() != null) // Поочередно каждый Объект из списка присваивается переменной post, затем фильтр по ненулевым голосам
                        .collect(Collectors.toList()) // Отфильтрованные значения собираются в список
                                .forEach(System.out :: println); // Список выводится по Объектам
    }

    // Преобразование JSON в Java-объекты. Создаем json-mapper
    public static ObjectMapper mapper = new ObjectMapper();
}
