package com.chinacnd.framework.db;

import com.chinacnd.framework.util.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * @author Hades
 */
public class Criteria<T> {

    Class<T> clazz;
    List<Criterion> criterions = new LinkedList<Criterion>();
    List<Order> orders = new LinkedList<Order>();
    Map<String, String> alias = new HashMap<String, String>();
    Integer maxResult;
    Integer firstResult;

    public static <T> Criteria<T> of(Class<T> clazz) {
        return new Criteria<T>(clazz);
    }

    Criteria(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Criteria<T> eq(String property, String value) {
        criterions.add(Restrictions.eq(property, value));
        return this;
    }

    public Criteria<T> ge(String string, Object value) {
        this.criterions.add(Restrictions.ge(string, value));
        return this;
    }

    public Criteria<T> isNull(String property) {
        criterions.add(Restrictions.isNull(property));
        return this;
    }

    public Criteria<T> alias(String associationPath, String alias) {
        this.alias.put(associationPath, alias);
        return this;
    }

    public Criteria<T> al(String property) {
        criterions.add(Restrictions.isNull(property));
        return this;
    }

    public Criteria<T> eq(String property, Object value) {
        criterions.add(Restrictions.eq(property, value));
        return this;
    }

    public Criteria<T> ne(String property, String value) {
        criterions.add(Restrictions.ne(property, value));
        return this;
    }

    public Criteria<T> ge(String property, String value) {
        criterions.add(Restrictions.ge(property, value));
        return this;
    }

    public Criteria<T> ne(String property, Object value) {
        criterions.add(Restrictions.ne(property, value));
        return this;
    }

    public Criteria<T> in(String property, Object[] values) {
        criterions.add(Restrictions.in(property, values));
        return this;
    }

    public Criteria<T> in(String property, Collection values) {
        criterions.add(Restrictions.in(property, values));
        return this;
    }

    public Criteria<T> like(String property, String value) {
        if (StringUtils.hasText(value)) {
            criterions.add(Restrictions.like(property, value, MatchMode.ANYWHERE));
        }
        return this;
    }

    public Criteria<T> between(String property, Number minValue, Number maxValue) {
        criterions.add(Restrictions.between(property, minValue, maxValue));
        return this;
    }

    public Criteria<T> orderBy(OrderBy orderBy) {
        switch (orderBy.getOrder()) {
            case ASC:
                orders.add(Order.asc(orderBy.getProperty()));
                break;
            case DESC:
                orders.add(Order.desc(orderBy.getProperty()));
                break;
        }
        return this;
    }

    public Criteria<T> fetch(int maxResult) {
        this.maxResult = maxResult;
        return this;
    }

    public Criteria<T> startFrom(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    org.hibernate.Criteria createCriteria(Session session) {
        org.hibernate.Criteria criteria = session.createCriteria(clazz);
        for (Map.Entry<String, String> pathAlias : alias.entrySet()) {
            criteria.createAlias(pathAlias.getKey(), pathAlias.getValue());
        }
        for (Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        for (Order order : orders) {
            criteria.addOrder(order);
        }
        if (firstResult != null) {
            criteria.setFirstResult(firstResult);
        }
        if (maxResult != null) {
            criteria.setMaxResults(maxResult);
        }
        return criteria;
    }
}
