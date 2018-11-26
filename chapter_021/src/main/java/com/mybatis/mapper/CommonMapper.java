package com.mybatis.mapper;

//import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * This class represents common interface for classes.
 * @author Svyatoslav Sabirov.
 * @since 22.11.2018
 * @version 7.
 */
//@Mapper
public interface CommonMapper<T> {
    void addEntity(T value);
    void removeEntity(T value);
    T getEntityById(long id);
    void updateEntity(T value);
    List<T> getListOfEntities();
}
