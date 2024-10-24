package com.cibertec.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.Clases.Blogger;
import com.cibertec.Clases.Blogs;

@Repository
public interface BlogsRepositorys extends JpaRepository<Blogger, Integer> {

	Blogs saveAll(Blogs blog);

	List<Blogs> findByTituloContaining(String titulo);
}
