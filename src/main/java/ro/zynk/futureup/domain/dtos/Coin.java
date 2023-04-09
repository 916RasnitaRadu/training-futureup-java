package ro.zynk.futureup.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.zynk.futureup.controllers.responses.CoinResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "coins")
public class Coin extends BaseEntity {

    @Column
    private String name;

    @Column
    private Double value;

    public Coin() {
    }

    public Coin(CoinResponse coin) {
        this.name = coin.getName();
        this.value = coin.getValue();
    }

    public Coin(String name, Double value) {
        this.name = name;
        this.value = value;
    }


}
