package de.aittr.g_52_shop.security.sec_dto;

import java.util.Objects;

public class TokenResponseDto {

    private String accessToken;
    private String refreshToken;

    public TokenResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }

    public TokenResponseDto() {
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public TokenResponseDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TokenResponseDto that = (TokenResponseDto) o;
        return Objects.equals(accessToken, that.accessToken) && Objects.equals(refreshToken, that.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, refreshToken);
    }

    @Override
    public String toString() {
        return String.format("TokenResponseDto: accessToken - %s, refreshToken - %s.",
                accessToken, refreshToken);
    }
}
