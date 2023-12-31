package com.learn.hibernate6.repository;

import com.learn.hibernate6.model.dao.User;
import com.learn.hibernate6.model.dto.OrderTupleForUser;
import com.learn.hibernate6.model.dto.OrderTupleForUserWithUserName;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserNativeQuerryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getListOfUsers() {
        Session session = entityManager.unwrap(Session.class);
        List<User> contacts = session.createNativeQuery("""
                SELECT
                    users.*, CONCAT(last, ', ', first) complete_name
                FROM
                    users
                """, User.class).list();
        return contacts;
    }

    public List<OrderTupleForUser> getPurchaseHistoryOfUser(Integer userId) {
        Session session = entityManager.unwrap(Session.class);
        List<OrderTupleForUser> orderHistory = session.createNativeQuery("""
                SELECT
                	o.order_id,
                    o.order_date,
                    p.name AS product_name,
                    oi.quantity,
                    oi.price_per_unit,
                    oi.quantity * oi.price_per_unit AS total_price
                FROM
                    Orders o
                        JOIN
                    Order_Items oi ON o.order_id = oi.order_id
                        JOIN
                    Products p ON oi.product_id = p.product_id
                WHERE
                    o.user_id = :userid
                """, OrderTupleForUser.class).setParameter("userid", userId).list();
        return orderHistory;
    }

    public List<OrderTupleForUserWithUserName> getPurchaseHistoryOfUserWithUserName(Integer userId) {
        Session session = entityManager.unwrap(Session.class);
        List<OrderTupleForUserWithUserName> orderHistory = session.createNativeQuery("""
                SELECT
                    o.order_id,
                    o.order_date,
                    p.name AS product_name,
                    oi.quantity,
                    oi.price_per_unit,
                    oi.quantity * oi.price_per_unit AS total_price,
                    CONCAT(first, ' ', last) AS username
                FROM
                    Orders o
                        JOIN
                    Order_Items oi ON o.order_id = oi.order_id
                        JOIN
                    Products p ON oi.product_id = p.product_id
                        JOIN
                    Users u ON u.user_id = o.user_id
                WHERE
                    o.user_id = :userid
                """, OrderTupleForUserWithUserName.class).setParameter("userid", userId).list();
        return orderHistory;
    }


}
