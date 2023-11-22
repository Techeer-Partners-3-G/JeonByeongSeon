package com.example.mymovie.domain.movie.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;




/*
자바 인터페이스
spring Data JPA 사용
Movie 엔티티에 대한 CRUD 기능 제공

이해가 잘 안감
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByGenreAndOnScreenOrderByOpenDate(MovieGenre genre, boolean onScreen);

    List<Movie> findAllByOnScreenOrderByOpenDate(boolean onScreen);

    List<Movie> findAllByGenreOrderByOpenDate(MovieGenre genre);


//    @Query("SELECT new com.example.mymovie.domain.movie.dto.response.MovieWithAvgScoreResponse(" +
//            "m.id, m.title, m.openDate, m.endDate, m.genre, m.onScreen, AVG(r.score)) " +
//            "FROM Movie m LEFT JOIN Review r ON r.movie = m " +
//            "GROUP BY m.id " +
//            "ORDER BY AVG(r.score) DESC")
//        Page<MovieWithAvgScoreResponse> findAllMoviesOrderByAverageScore(Pageable pageable);
//    }

}
