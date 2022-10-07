package org.example.repository;

import org.example.entities.MyEntity;

import java.util.List;

public interface ClientRepo {

    MyEntity create(MyEntity entity);

    MyEntity read(int id);

    List<MyEntity> readAll();

    MyEntity update(int id, MyEntity entity);

    boolean delete(int id);

}
