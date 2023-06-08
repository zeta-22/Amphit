import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class ProductTimer {
    public static void main(String[] args) {
        // Creazione di un prodotto con timer
        Product product = new Product("Prodotto 1");
        product.setExpirationDateTime(calculateExpirationDateTimeForProduct1());

        // Generazione del codice HTML per il timer del prodotto
        String timerHtml = generateTimerHtml(product);

        // Stampa del codice HTML
        System.out.println(timerHtml);
    }

    // Calcola la data di scadenza per il prodotto 1
    private static LocalDateTime calculateExpirationDateTimeForProduct1() {
        // Implementazione personalizzata per il prodotto 1
        // Esempio: scade ogni sabato alle 12
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextSaturday = now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDateTime expirationDateTime = LocalDateTime.of(nextSaturday.getYear(), nextSaturday.getMonth(),
                nextSaturday.getDayOfMonth(), 12, 0);
        return expirationDateTime;
    }

    // Genera il codice HTML per visualizzare il timer del prodotto
    private static String generateTimerHtml(Product product) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<div class=\"product\">");
        htmlBuilder.append("<h3>").append(product.getName()).append("</h3>");
        htmlBuilder.append("<div id=\"").append(product.getId()).append("\"></div>");
        htmlBuilder.append("</div>");

        htmlBuilder.append("<script>");
        htmlBuilder.append("var expirationDateTime = new Date('").append(product.getExpirationDateTime()).append("');");
        htmlBuilder.append("var countdownElement = document.getElementById('").append(product.getId()).append("');");
        htmlBuilder.append("setInterval(function() {");
        htmlBuilder.append("var now = new Date();");
        htmlBuilder.append("var remainingTime = expirationDateTime - now;");
        htmlBuilder.append("var days = Math.floor(remainingTime / (24 * 60 * 60 * 1000));");
        htmlBuilder.append("var hours = Math.floor((remainingTime % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000));");
        htmlBuilder.append("var minutes = Math.floor((remainingTime % (60 * 60 * 1000)) / (60 * 1000));");
        htmlBuilder.append("var seconds = Math.floor((remainingTime % (60 * 1000)) / 1000);");
        htmlBuilder.append("countdownElement.textContent = 'Scade tra: ' + days + ' giorni, ' + hours + ' ore, ' + minutes + ' minuti, ' + seconds + ' secondi';");
        htmlBuilder.append("}, 1000);");
        htmlBuilder.append("</script>");

        return htmlBuilder.toString();
    }
}

class Product {
    private String id;
    private String name;
    private LocalDateTime expirationDateTime;

    public Product(String name) {
        this.name = name;
        this.id = "timer-" + System.currentTimeMillis(); // Generazione di un ID univoco basato sul timestamp
    }

    // Metodi getter/setter per expirationDateTime, id e name
    // ...

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(LocalDateTime expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }
}
