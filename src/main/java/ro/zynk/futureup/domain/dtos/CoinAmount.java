package ro.zynk.futureup.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "coin_amounts", uniqueConstraints = {@UniqueConstraint(columnNames = {"wallet_id", "coin_id"})})
public class CoinAmount extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "coin_id")
    private Coin coin;

    @Column
    private Double amount;


}
