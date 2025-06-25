package com.bd.jpa.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.jpa.modelo.TblProducto;
import com.bd.jpa.repositorio.IProductoRepositorio;

@Service
public class ProductoServicioImp implements IProductoServicio{
//aplicamos la inyeccion de dependencia
	@Autowired
	private IProductoRepositorio iproductorepositorio;
	@Override
	public void RegistrarProducto(TblProducto tblprod) {
		iproductorepositorio.save(tblprod);
	} //FIN DE DEL METODO....

	@Override
	public void EliminarProducto(TblProducto tblprod) {
         //invocamos el metodo eliminar
		iproductorepositorio.deleteById(tblprod.getIdproducto());
	}//FIN DE DEL METODO....

	@Override
	public List<TblProducto> ListadoProductos() {
		// TODO Auto-generated method stub
		return (List<TblProducto>)iproductorepositorio.findAll();
	}//FIN DE DEL METODO....

	@Override
	public TblProducto BuscarporId(Integer id) {
		// TODO Auto-generated method stub
		return iproductorepositorio.findById(id).orElse(null);
	}//FIN DE DEL METODO....

} //fin de la clase
