package com.example.accesskeybackend.template.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the result of IPv6 check by site URL
 */
@Data
public class IPv6SupportResultDto implements Serializable {
    @NotNull
    private Boolean success;
}