package com.example.songr;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Supplier;

public interface SongRepository extends JpaRepository<Song,Integer> {
    Supplier<Album> findById(Album album);
}
