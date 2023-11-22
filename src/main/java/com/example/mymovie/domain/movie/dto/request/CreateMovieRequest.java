package com.example.mymovie.domain.movie.dto.request;


import com.example.mymovie.domain.movie.domain.Movie;
import com.example.mymovie.domain.movie.domain.MovieGenre;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cglib.core.Local;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@Schema(description = "영화 생성을 위한 요청")
public class CreateMovieRequest {

    @Schema(description = "영화의 제목")
    private String title;

    @Schema(description = "영화의 장르")
    private MovieGenre genre;

    @Schema(description = "영화 상영 시작일", pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate openDate;

    @Schema(description = "영화 상영 종료일", pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

//    public CreateMovieRequest() {
//    }

    public Movie toEntity() {
        boolean onScreen = LocalDate.now().isAfter(this.openDate) && LocalDate.now().isBefore(this.endDate);
        return new Movie(
                this.title,
                this.genre,
                this.openDate,
                this.endDate,
                onScreen
        );
    }

}
