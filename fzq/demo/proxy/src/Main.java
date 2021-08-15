public class Main {
    public static void main(String[] args) {
        Language language = new Dog();
        proxySpeak(language);
        proxySpeak(new Cat());
    }

    private static void proxySpeak(Language language) {
        LanguageProxy proxy = new LanguageProxy(language);
        Language proxyLanguage = (Language) proxy.getProxy();
        proxyLanguage.speak();
    }
}
