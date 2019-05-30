package stock.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stock.demo.dto.StockDTO;
import stock.demo.service.custom.ManageItemsService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/vi/stock")
public class StockController {

        @Autowired
        private ManageItemsService manageItemsService;

        @GetMapping
        public ResponseEntity<List<StockDTO>> findAllStock() {
            System.out.println("sssssssssssssssssssssssssssssssssss");
            List<StockDTO> stocks = manageItemsService.getItems();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("X-Count", stocks.size() + "");

            return new ResponseEntity<List<StockDTO>>(stocks, httpHeaders, HttpStatus.OK);
        }
            @GetMapping("/{code:I\\d{3}}")
        public StockDTO findCustomer(@PathVariable("code") String code){
            StockDTO item = manageItemsService.findItem(code);
            return item;
        }

        @DeleteMapping("/{code:I\\d{3}}")
        @ResponseStatus(HttpStatus.OK)
        public void deleteCustomer(@PathVariable("code") String code){
            manageItemsService.deleteItem(code);
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.CREATED)
        public String saveCustomer(@RequestBody StockDTO stockDTO){
            manageItemsService.createItem(stockDTO);
            return stockDTO.getCode();
        }

        @PutMapping(value = "/{code:I\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity updateCustomer(@PathVariable("code") String code, @RequestBody StockDTO stockDTO){
            if (code.equals(stockDTO.getCode())){
                manageItemsService.updateItem(stockDTO);
                return new ResponseEntity(HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
}
