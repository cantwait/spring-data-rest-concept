package com.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.data.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{

}
