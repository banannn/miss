package miss.message;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

public class Offer extends Question {
    public static final String OK = "ok";
    public static final String OFERTA_S_POTWIERDŹ_S = "Oferta: %s (potwierdź: %s)";
    @XmlElement
    private final BigDecimal sum;

    private Offer() {
        sum = null;
    }

    public Offer(Long id, BigDecimal sum) {
        super(id);
        this.sum = sum;
    }

    @Override
    public Message parseResponse(String response) {
        if (response.trim().toLowerCase().startsWith(OK)) return new OfferAccept();
        return new OfferReject();
    }

    @Override
    public String toString() {
        return String.format(OFERTA_S_POTWIERDŹ_S, sum.toString(), OK);
    }
}
