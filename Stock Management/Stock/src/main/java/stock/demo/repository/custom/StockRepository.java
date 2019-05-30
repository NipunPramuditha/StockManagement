package stock.demo.repository.custom;

import stock.demo.entity.Stock;
import stock.demo.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, String >{
}
