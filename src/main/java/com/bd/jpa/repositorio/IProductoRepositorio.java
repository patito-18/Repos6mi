package com.bd.jpa.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.bd.jpa.modelo.TblProducto;

public interface IProductoRepositorio extends CrudRepository<TblProducto,Integer>{

}  //fin de la interface...
