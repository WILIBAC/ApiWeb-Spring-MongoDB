package com.wilibac.empleados.backend.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wilibac.empleados.backend.model.Empleado;

public interface IEmpleadoDao extends MongoRepository<Empleado, String>{

}
