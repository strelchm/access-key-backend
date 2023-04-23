package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.template.dto.IPv6SupportResultDto;
import com.example.accesskeybackend.template.mapper.IPv6SupportMapper;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

@Service
@AllArgsConstructor
//@Log4j2 the result of support check is visible in request / response logs
public class IPv6SupportService {

    private final IPv6SupportMapper iPv6SupportMapper;

    public IPv6SupportResultDto isIPv6Supported(final @NonNull String siteUrl) {
        try {
            InetAddress inetAddress = InetAddress.getByName(getHost(siteUrl));
            return iPv6SupportMapper.toDto(inetAddress instanceof Inet6Address);
        } catch (UnknownHostException ex) {
            throw new com.example.accesskeybackend.exception.IllegalArgumentException(String.format(
                    "Wrong Url: %s", siteUrl
            ));
        } catch (SecurityException  ex) {
            throw new com.example.accesskeybackend.exception.IllegalArgumentException(String.format(
                    "Url security manager exists and its checkConnect method doesn't allow the operation : %s", siteUrl
            ));
        }
    }

    private String getHost(String url) {
        try {
            return new URL(url).getHost();
        } catch (MalformedURLException e) {
            return url; // input url is already the host
        }
    }
}
