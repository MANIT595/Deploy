package com.manikanta.microservice.deploy.user.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "ErrorDTO Model"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    @Schema(
            description = "Error TimeStamp"
    )
    private LocalDateTime timestamp;

    @Schema(
            description = "Error Message"
    )
    private String message;

    @Schema(
            description = "Error Path"
    )
    private String path;

    @Schema(
            description = "Error Code"
    )
    private String errorCode;

    @Schema(
            description = "Error ResponseCode"
    )
    private Integer responseCode;
}
