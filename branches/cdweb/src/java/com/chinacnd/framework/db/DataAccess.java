package com.chinacnd.framework.db;

import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Hades
 */
@SuppressWarnings("unchecked")
public class DataAccess {

    private HibernateTemplate hibernateTemplate;

    public <T extends IdEntity> T get(Class<T> clazz, Serializable id) {
        return (T) hibernateTemplate.get(clazz, id);
    }

    public void save(Object entity) {
        hibernateTemplate.save(entity);
    }

    public void saveOrUpdate(IdEntity entity) {
        Long id = entity.getId();
        if (id == null || id <= 0) {
            hibernateTemplate.save(entity);
        } else {
            hibernateTemplate.update(entity);
        }
    }

    public void delete(Object entity) {
        hibernateTemplate.delete(entity);
    }

    public void update(Object entity) {
        hibernateTemplate.update(entity);
    }

    public int updateByHQL(final String hql, final Object... parameters) {
        return hibernateTemplate.bulkUpdate(hql, parameters);
    }

    public <T extends IdEntity> void delete(Serializable id, Class<T> poClass) {
        IdEntity po = (IdEntity) hibernateTemplate.load(poClass, id);
        hibernateTemplate.delete(po);
    }

    public <T extends IdEntity> List<T> findByHQL(String hql, Object... params) {
        List<T> list = hibernateTemplate.find(hql, params);
        if (list == null) {
            return Collections.EMPTY_LIST;
        } else {
            return list;
        }
    }

    public <T extends IdEntity> List<T> findByHQL(final Page page, final String hql, final Object... params) {
        return (List<T>) hibernateTemplate.executeWithNativeSession(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                for (int i = 0; i < params.length; i++) {
                    query.setParameter(i, params[i]);
                }
                ScrollableResults scrollableResults = query.scroll();
                scrollableResults.last();
                int rownum = scrollableResults.getRowNumber();
                page.setTotalCount(rownum + 1);
                query.setMaxResults(page.getLimit());
                query.setFirstResult(page.getStart());
                List ls = query.list();
                if (ls == null) {
                    ls = Collections.EMPTY_LIST;
                }
                return ls;
            }
        });
    }

    public <T extends IdEntity> List<T> findAll(Class<T> clazz) {
        List<T> list = hibernateTemplate.loadAll(clazz);
        if (list == null) {
            return Collections.EMPTY_LIST;
        } else {
            return list;
        }
    }

    public <T extends IdEntity> List<T> findAll(final Class<T> cls, final Page page) {
        return findByCriteria(new com.chinacnd.framework.db.Criteria<T>(cls), page);
    }

    public <T extends IdEntity> T findByUniqueProperty(Class<T> clazz, String propertyName, Object value) {
        com.chinacnd.framework.db.Criteria<T> criteria = com.chinacnd.framework.db.Criteria.of(clazz);
        criteria.eq(propertyName, value);
        return findUniqueResult(criteria);

    }

    public <T extends IdEntity> T findUniqueResult(final com.chinacnd.framework.db.Criteria<T> criteria) {
        return (T) hibernateTemplate.executeWithNativeSession(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                org.hibernate.Criteria hibernateCriteria = criteria.createCriteria(session);
                return hibernateCriteria.uniqueResult();
            }
        });
    }

    public <F> F findUniqueResult(final NamedQuery nQuery) {
        return (F) hibernateTemplate.executeWithNativeSession(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.getNamedQuery(nQuery.getQueryName());
                Map<String, Object> map = nQuery.getMap();
                for (Entry<String, Object> entry : map.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
                return query.uniqueResult();
            }
        });
    }

    public <T extends IdEntity> List<T> findByNamedQuery(final NamedQuery query) {
        Map<String, Object> map = query.getMap();
        String[] params = new String[map.size()];
        Object[] values = new Object[map.size()];
        int index = 0;
        for (Entry<String, Object> entry : map.entrySet()) {
            params[index] = entry.getKey();
            values[index] = entry.getValue();
        }
        List<T> list = hibernateTemplate.findByNamedQueryAndNamedParam(query.getQueryName(), params, values);
        if (list == null) {
            return Collections.EMPTY_LIST;
        } else {
            return list;
        }
    }

    public <T extends IdEntity> List<T> findByNamedQuery(final NamedQuery nQuery, final Page page) {
        return (List<T>) hibernateTemplate.executeWithNativeSession(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.getNamedQuery(nQuery.getQueryName());
                Map<String, Object> map = nQuery.getMap();
                for (Entry<String, Object> entry : map.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
                ScrollableResults scrollableResults = query.scroll();
                scrollableResults.last();
                int rownum = scrollableResults.getRowNumber();
                page.setTotalCount(rownum + 1);
                query.setMaxResults(page.getLimit());
                query.setFirstResult(page.getStart());
                List ls = query.list();
                if (ls == null) {
                    ls = Collections.EMPTY_LIST;
                }
                return ls;
            }
        });
    }

    public <T extends IdEntity> List<T> findByCriteria(final com.chinacnd.framework.db.Criteria<T> criteria) {
        return (List<T>) hibernateTemplate.executeWithNativeSession(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                org.hibernate.Criteria hibernateCriteria = criteria.createCriteria(session);
                return hibernateCriteria.list();
            }
        });
    }

    public <T extends IdEntity> List<T> findByCriteria(final com.chinacnd.framework.db.Criteria<T> criteria, final Page page) {
        return (List<T>) hibernateTemplate.executeWithNativeSession(new HibernateCallback() {

            @SuppressWarnings("unchecked")
            public Object doInHibernate(Session session) throws HibernateException {
                org.hibernate.Criteria countCriteria = criteria.createCriteria(session);
                countCriteria.setProjection(Projections.rowCount());
                int totalCount = ((Number) countCriteria.uniqueResult()).intValue();
                page.setTotalCount(totalCount);
                org.hibernate.Criteria hibernateCriteria = criteria.createCriteria(session);
                hibernateCriteria.setFirstResult(page.getStart());
                hibernateCriteria.setMaxResults(page.getLimit());
                List<T> list = hibernateCriteria.list();
                if (list == null) {
                    return Collections.EMPTY_LIST;
                } else {
                    return list;
                }
            }
        });
    }

    public List<?> findBySQL(final String sql, final Object... params) {
        return (List<?>) hibernateTemplate.executeWithNativeSession(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(sql);
                for (int i = 0; i < params.length; i++) {
                    Object para = params[i];
                    query.setParameter(i, para);
                }
                return query.list();
            }
        });
    }

    public List<?> findBySQL(final Page page, final String sql, final Object... params) {
        return (List<?>) hibernateTemplate.executeWithNativeSession(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(sql);
                for (int i = 0; i < params.length; i++) {
                    Object para = params[i];
                    query.setParameter(i, para);
                }
                ScrollableResults scrollableResults = query.scroll();
                scrollableResults.last();
                int rownum = scrollableResults.getRowNumber();
                page.setTotalCount(rownum + 1);
                query.setMaxResults(page.getPageCount());
                query.setFirstResult(page.getStart());
                return query.list();
            }
        });
    }

    public int updateBySQL(final String sql, final Object... params) {
        return (Integer) hibernateTemplate.executeWithNativeSession(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(sql);
                for (int i = 0; i < params.length; i++) {
                    Object para = params[i];
                    query.setParameter(i, para);
                }
                return query.executeUpdate();
            }
        });
    }

    public final void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
}
