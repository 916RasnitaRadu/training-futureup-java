package ro.zynk.futureup.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "transactions", uniqueConstraints = {@UniqueConstraint(columnNames = {"coin_id"})})
public class Transaction extends BaseEntity {

    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "coin_id")
    private Coin coin;

    private Float Amount;

    private Double totalValue;
}
