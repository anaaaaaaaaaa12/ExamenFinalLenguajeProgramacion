package com.cibertec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.Clases.Blogger;

@Repository
public interface BloggerRepositorys extends JpaRepository<Blogger, Integer> {
}

