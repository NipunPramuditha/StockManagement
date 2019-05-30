package stock.demo.repository.custom.impl;

import org.springframework.stereotype.Repository;
import stock.demo.entity.Stock;
import stock.demo.repository.CrudRepositoryImpl;
import stock.demo.repository.custom.StockRepository;
@Repository
public class StockRepositoryImpl extends CrudRepositoryImpl<Stock, String > implements StockRepository {

}
