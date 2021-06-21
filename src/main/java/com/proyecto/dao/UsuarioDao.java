package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}
