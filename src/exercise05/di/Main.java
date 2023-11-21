package exercise05.di;

public class Main {

    public static void main(String[] args) {
        System.out.println("----- Mit Log in der Datei:");
        //1e
        ILogService fileLogService = new FileLogService();
        WebCrawlerService webCrawlerService1 = new WebCrawlerService(fileLogService);
        String email = webCrawlerService1.findEmail("https://www.htwg-konstanz.de/hochschule/fakultaeten/informatik/orga/professoren/bohnet/");
        System.out.println("- EMAIL: " + email);

        //1e
        ILogService consoleLogService = new ConsoleLogService();
        WebCrawlerService webCrawlerService2 = new WebCrawlerService(consoleLogService);
        String email2 = webCrawlerService2.findEmail("https://www.htwg-konstanz.de/hochschule/fakultaeten/informatik/orga/professoren/schneider/");
        System.out.println("- EMAIL: " + email2);

        //1f
        ILogService dummyLogService = new ILogService() {
            @Override
            public void log(String massage) {
            }
        };

        WebCrawlerService webCrawlerService3 = new WebCrawlerService(dummyLogService);
        String email3 = webCrawlerService3.findEmail("https://www.htwg-konstanz.de/hochschule/fakultaeten/informatik/orga/professoren/schneider/");
        System.out.println("- EMAIL: " + email3);
    }
}