import java.math.BigDecimal;
import java.time.Duration;
import java.util.Objects;

public class Movie {

    private Long id;
    private String name;
    private Duration duration;
    private BigDecimal ticketPrice;
    private String ticketPriceCurrency;

    public Movie(Long id, String name, Duration duration, BigDecimal ticketPrice, String ticketPriceCurrency) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
        this.ticketPriceCurrency = ticketPriceCurrency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketPriceCurrency() {
        return ticketPriceCurrency;
    }

    public void setTicketPriceCurrency(String ticketPriceCurrency) {
        this.ticketPriceCurrency = ticketPriceCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(duration, movie.duration) && Objects.equals(ticketPrice, movie.ticketPrice) && Objects.equals(ticketPriceCurrency, movie.ticketPriceCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, ticketPrice, ticketPriceCurrency);
    }

}
