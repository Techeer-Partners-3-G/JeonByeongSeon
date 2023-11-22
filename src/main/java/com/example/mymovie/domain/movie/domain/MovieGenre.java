package com.example.mymovie.domain.movie.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public enum MovieGenre {

    @Schema(description = "액션 영화")
    ACTION,

    @Schema(description = "스릴러 영화")
    THRILLER,

    @Schema(description = "로맨스 영화")
    ROMANCE,

    @Schema(description = "코미디 영화")
    COMEDY

}
