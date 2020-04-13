package com.uatx.app.correos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uatx.app.correos.model.User;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Long> {

}
