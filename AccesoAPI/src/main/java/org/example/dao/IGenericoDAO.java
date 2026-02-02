package org.example.dao;

import org.example.model.dto.Player;

import java.util.List;

public interface IGenericoDAO<T> {

    void insertar(T entidad);
    T buscarPorID(int id);
    List<T> sacarTodos();
    void actualizar(T entidad);
    void borrar(int id);
}
