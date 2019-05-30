package stock.demo.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stock.demo.dto.StockDTO;
import stock.demo.repository.custom.StockRepository;
import stock.demo.service.Converter;
import stock.demo.service.custom.ManageItemsService;

import java.util.List;

@Service
@Transactional
public class ManageItemsServiceImpl implements ManageItemsService{

    private StockRepository stockDAO;

    @Autowired
    public ManageItemsServiceImpl(StockRepository stockDAO){
        this.stockDAO = stockDAO;
    }



    @Transactional(readOnly = true)
    public List<StockDTO> getItems() {
        return stockDAO.findAll().map(Converter::<StockDTO>getDTOList).get();
    }


    public void createItem(StockDTO dto) {
        stockDAO.save(Converter.getEntity(dto));
    }


    public void updateItem(StockDTO dto) {
        stockDAO.update(Converter.getEntity(dto));
        }


public void deleteItem(String code) {
        stockDAO.delete(code);
        }


public StockDTO findItem(String code) {
        return stockDAO.find(code).map(Converter::<StockDTO>getDTO).orElse(null);
        }
}