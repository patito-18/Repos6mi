package com.bd.jpa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.jpa.modelo.TblProducto;
import com.bd.jpa.servicio.IProductoServicio;




@Controller
@RequestMapping("/vistas")
public class ProductoController {

	//inyeccion de dependencia...
	@Autowired
	private IProductoServicio iproductoservicio;
	@GetMapping("ListadoProductos")
	public String ListadoProducto(Model modelo) {
		//recuperamos los datos de la bd...
		List<TblProducto> listado=iproductoservicio.ListadoProductos();
		//enviamos hacia la vista
		modelo.addAttribute("listado",listado);
		//retornamos
		return "/Vistas/ListadoProductos";		
	}   //fin del metodo listado....
	
	//creamos el metodo para registrar...
	@GetMapping("/RegistrarProducto")
	public String RegistrarProducto(Model modelo) {
		//realizamos la respectiva instancia....
		TblProducto tblprod=new TblProducto();
		//enviamos hacia la vista
		modelo.addAttribute("regproducto",tblprod);
		//retornamos el formulario
		return "/Vistas/FrmRegProducto";
		
	}//fin del metodo
	
	//realizamos el mapeo con postmapping...
	@PostMapping("/GuardarProducto")
	public String GuardarProducto(@ModelAttribute 
			TblProducto tblprod,Model modelo) {
		iproductoservicio.RegistrarProducto(tblprod);
		//emitimos mensaje por consola
		System.out.println("Dato registrado en la BD!!!!!1");
		//retornamos el  listado
		return "redirect:/vistas/ListadoProductos";
	} //fin del metodo.....
	
	/****************************************/
	
	//creamos metodo editar
	@GetMapping("/editarproducto/{id}")
	public String Editar(@PathVariable("id") Integer idproducto,Model modelo) {
		//creamos un obj de tipo tblproducto...
		TblProducto clproducto=iproductoservicio.BuscarporId(idproducto);
		//Enviamos a la vista 
		modelo.addAttribute("regproducto", clproducto);
		//eviamos al frmregproducto..
		return "Vistas/FrmRegProducto";
	}//fin del metodo edit
	/*
	//creamos metodo eliminar
	@GetMapping("eliminarproducto/{id}")
	public String eliminar (@PathVariable("id")Integer idproducto,Model modelo ) {
		TblProducto tblpro=new TblProducto();
		tblpro.setIdproducto(idproducto);
		//aplicamos la inyeccion de dependencia..
		iproductoservicio.EliminarProducto(tblpro);
		//actualizamos el listado 
		List<TblProducto> listado=iproductoservicio.ListadoProductos();
		//enviamos hacia la vista 
		modelo.addAttribute("listado", listado);
		//redireccionamos
		return "redirect:/vistas/ListadoProductos";
	}//fin me . eliminar
	*/
}//fin de la clase....
