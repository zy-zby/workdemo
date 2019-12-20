package jxnu.chisha.dao;

import jxnu.chisha.domain.OrderDetailDomain;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDao {
    public List<OrderDetailDomain> getListByOrder(int orderId) throws SQLException;
    public void addOrder(List<OrderDetailDomain> items,int orderId) throws SQLException;
}
