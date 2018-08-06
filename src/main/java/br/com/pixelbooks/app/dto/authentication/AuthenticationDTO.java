package br.com.pixelbooks.app.dto.authentication;

public class AuthenticationDTO {
    private String token;

    private String createDate;

    private String expirationDate;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "AuthenticationDTO{" +
                "token='" + token + '\'' +
                ", createDate='" + createDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
