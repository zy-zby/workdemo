package jxnu.chisha.dao;

import jxnu.chisha.domain.OrderDomain;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    public List<OrderDomain> getListByCust(int custId) throws SQLException;
    public int addOrder(OrderDomain orderDomain) throws SQLException;
}
