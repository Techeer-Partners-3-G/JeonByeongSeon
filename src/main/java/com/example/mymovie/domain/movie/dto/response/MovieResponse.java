package com.example.mymovie.domain.movie.dto.response;


import com.example.mymovie.domain.movie.domain.Movie;
import com.example.mymovie.domain.movie.domain.MovieGenre;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Schema(description = "영화 정보에 대한 응답")
public class MovieResponse {

    @Schema(description = "영화의 고유 식별자")
    private Long id;

    @Schema(description = "영화 제목")
    private String title;

    @Schema(description = "영화 장르")
    private MovieGenre genre;

    @Schema(description = "영화 개봉일")
    private LocalDate openDate;

    @Schema(description = "영화 종영일")
    private LocalDate endDate;

    @Schema(description = "현재 상영 여부")
    private Boolean onScreen;


//    public MovieResponse() {
//    }

    public MovieResponse(Long id, String title, MovieGenre genre, LocalDate openDate, LocalDate endDate, boolean onScreen) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.openDate = openDate;
        this.endDate = endDate;
        this.onScreen = onScreen;

        }

    public static MovieResponse of (Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getOpenDate(),
                movie.getEndDate(),
                movie.isOnScreen()
        );
    }


//    public static MovieResponse of(Movie movie) {
//        return new MovieResponse(
//                movie.getId(),
//                movie.getTitle(),
//                movie.getOpenDate(),
//                movie.getEndDate(),
//                movie.isOnScreen(),
//                movie.getGenre()
//        );
//    }

}
