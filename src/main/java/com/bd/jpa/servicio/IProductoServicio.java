package com.bd.jpa.servicio;

import java.util.List;

import com.bd.jpa.modelo.TblProducto;

public interface IProductoServicio {
//declaramos los metodos
	void RegistrarProducto(TblProducto tblprod);
	void EliminarProducto(TblProducto tblprod);
	List<TblProducto> ListadoProductos();
	TblProducto BuscarporId(Integer id);
}//fin de la interface....
