package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.dto.IPv6SupportResultDto;
import com.example.accesskeybackend.template.service.IPv6SupportService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web/checkIpv6Support")
@AllArgsConstructor
@Validated
public class IPv6SupportController {

    private final IPv6SupportService iPv6SupportService;

    @GetMapping
    public IPv6SupportResultDto templateById(
            @Parameter(description = "Site URL")
            @RequestParam(required = false) // 4 custom error response with @NotEmpty
            @NotEmpty String siteUrl
    ) {
        return iPv6SupportService.isIPv6Supported(siteUrl);
    }
}
