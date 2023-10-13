package repository;

import model.OrderDetail;
import model.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query("select o from OrderTable o where o.customer.id = ?1")
    List<OrderTable> findAllByCustomerId(Long id);
}
