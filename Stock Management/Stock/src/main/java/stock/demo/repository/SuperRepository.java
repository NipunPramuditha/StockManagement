package stock.demo.repository;

import org.hibernate.Session;

public interface SuperRepository {

    Session getSession();

}
