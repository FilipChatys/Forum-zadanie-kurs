package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private User user;
    private final Set<OrderPosition> orderPositions = new HashSet<>();
    private Status status;
    private double total;
    private LocalDateTime dateTime;

    public String getPrettyTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return this.dateTime.format(formatter);
    }

    public enum Status {
        NEW,
        PAID,
        SENT,
        DONE
    }
}