package com.example.songr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRespository extends CrudRepository<Album, Integer> {
}
