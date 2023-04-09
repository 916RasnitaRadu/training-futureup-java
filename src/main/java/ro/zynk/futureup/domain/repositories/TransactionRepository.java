package ro.zynk.futureup.domain.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.zynk.futureup.domain.dtos.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
    List<Transaction> findAll();
}
