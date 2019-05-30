package stock.demo.service.custom;


import stock.demo.dto.StockDTO;
import stock.demo.service.SuperService;

import java.util.List;

public interface ManageItemsService extends SuperService {

    List<StockDTO> getItems();

    void createItem(StockDTO dto);

    void updateItem(StockDTO dto);

    void deleteItem(String code);

    StockDTO findItem(String code);


}
