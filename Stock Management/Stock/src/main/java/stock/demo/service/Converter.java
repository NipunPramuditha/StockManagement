package stock.demo.service;

import stock.demo.dto.StockDTO;
import stock.demo.dto.SuperDTO;
import stock.demo.entity.Stock;
import stock.demo.entity.SuperEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof Stock) {
            Stock i = (Stock) entity;
            return (T) new StockDTO(i.getImgLink(), i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand(), i.getUserID());
        } else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof StockDTO) {
            StockDTO i = (StockDTO) dto;
            return (T) new Stock( i.getImgLink(),i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand(), i.getUserID());
        } else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

}
