package com.chinacnd.framework.db;

import com.chinacnd.framework.util.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;

@SuppressWarnings("unchecked")
public abstract class EntityDAO<T extends IdEntity> {

    @Resource
    private DataAccess dataAccess;
    private Class<T> entityClass;

    protected int updateBySQL(String sql, Object... params) {
        return dataAccess.updateBySQL(sql, params);
    }

    protected int updateByHQL(String hql, Object... parameters) {
        return dataAccess.updateByHQL(hql, parameters);
    }

    protected void update(T entity) {
        dataAccess.update(entity);
    }

    protected void saveOrUpdate(T entity) {
        dataAccess.saveOrUpdate(entity);
    }

    protected void save(Object entity) {
        dataAccess.save(entity);
    }

    protected T get(Serializable id) {
        return dataAccess.get(entityClass(), id);
    }

    protected <T extends IdEntity> T findUniqueResult(Criteria<T> criteria) {
        return dataAccess.findUniqueResult(criteria);
    }

    protected <F> F findUniqueResult(NamedQuery namedQuery) {
        return (F) dataAccess.findUniqueResult(namedQuery);
    }

    protected T findByUniqueProperty(String propertyName, Object value) {
        return dataAccess.findByUniqueProperty(entityClass(), propertyName, value);
    }

    protected List<?> findBySQL(Page page, String sql, Object... params) {
        return dataAccess.findBySQL(page, sql, params);
    }

    protected List<?> findBySQL(String sql, Object... params) {
        return dataAccess.findBySQL(sql, params);
    }

    protected <T extends IdEntity> List<T> findByNamedQuery(NamedQuery nQuery, Page page) {
        return dataAccess.findByNamedQuery(nQuery, page);
    }

    protected <T extends IdEntity> List<T> findByNamedQuery(NamedQuery query) {
        return dataAccess.findByNamedQuery(query);
    }

    protected <T extends IdEntity> List<T> findByHQL(Page page, String hql, Object... params) {
        return dataAccess.findByHQL(page, hql, params);
    }

    protected <T extends IdEntity> List<T> findByHQL(String hql, Object... params) {
        return dataAccess.findByHQL(hql, params);
    }

    protected <T extends IdEntity> List<T> findByCriteria(Criteria<T> criteria, Page page) {
        return dataAccess.findByCriteria(criteria, page);
    }

    protected <T extends IdEntity> List<T> findByCriteria(Criteria<T> criteria) {
        return dataAccess.findByCriteria(criteria);
    }

    protected List<T> findAll(Page page) {
        return dataAccess.findAll(entityClass(), page);
    }

    protected List<T> findAll() {
        return dataAccess.findAll(entityClass());
    }

    protected void deleteById(Serializable id) {
        dataAccess.delete(id, entityClass());
    }

    protected void delete(T t) {
        dataAccess.delete(t);
    }

    protected void saveFromForm(Object form) {
        T object = BeanUtils.newInstance(entityClass());
        BeanUtils.copyProperties(object, form);
        save(object);
    }

    protected void loadEntityIntoForm(String id, Object form) {
        T entity = get(id);
        BeanUtils.copyProperties(form, entity);
    }

    protected Class<T> entityClass() {
        if (entityClass == null) {
            entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;
    }
}
