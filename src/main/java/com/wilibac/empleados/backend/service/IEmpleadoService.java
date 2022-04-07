package com.wilibac.empleados.backend.service;

import java.util.List;

import com.wilibac.empleados.backend.model.Empleado;

public interface IEmpleadoService {

	List<Empleado> buscar();
	Empleado buscarPorId(String id);
	Empleado guardar(Empleado empleado);
	void eliminar(String id);

}
