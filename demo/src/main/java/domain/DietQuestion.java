package domain;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class DietQuestion {

    @Id
    @GeneratedValue
    @Column(name = "dq_date")
    private final Long id;

    private final LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private final User user;

    public DietQuestion(Long id, LocalDate date, User user) {
        this.id = id;
        this.date = date;
        this.user = user;
    }
}
