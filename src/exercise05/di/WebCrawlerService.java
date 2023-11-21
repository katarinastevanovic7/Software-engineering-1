package exercise05.di;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawlerService {

    //1d
    private ILogService logService;
        public WebCrawlerService(ILogService logService) {
            this.logService = logService;
            this.logService.log("EmailCrawlService initiated.");

    //private FileLogService logService;
    //public WebCrawlerService() {
       // this.logService = new FileLogService();
       // this.logService.log("EmailCrawlService initiated.");
    }

    private static final Pattern SIMPLE_EMAIL_PATTERN = Pattern.compile("\\S+@\\S+\\.\\S+");

    //nimmt eine URL als Eingabe und versucht, eine HTTP Anfrage an diese URL zu senden
    //nach HTTP Antwort wird der Text nach einer einfachen Email Adresse durchsucht
    // wenn eine E-Mail-Adresse gefunden wird, wird sie dokumentiert und zurückgegeben, ansonsten null
    public String findEmail(String url) {
        logService.log("Creating request to " + url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            logService.log("Executing request.");
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            logService.log("Got response with status " + response.statusCode());
            Matcher matcher = SIMPLE_EMAIL_PATTERN.matcher(response.body());
            if (matcher.find()) {
                String email = matcher.group();
                logService.log("Found email " + email);
                return email;
            }
            return null;
        } catch (IOException | InterruptedException e) {
            logService.log("Got exception " + e.getMessage());
            logService.log("returning null");
            return null;
        }
    }
}
