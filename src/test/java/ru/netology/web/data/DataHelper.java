package ru.netology.web.data;

import lombok.Value;

import java.util.Random;


public class DataHelper {

    private DataHelper () {}

    @Value
    public static class AuthInfo{
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo (){
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo (){
        return new AuthInfo("petya", "123qwerty");
    }
    @Value
    public static class VerificationCode{
        private String code;
    }
    public static VerificationCode getVerificationCode(){
        return new VerificationCode("12345");
    }
    @Value
    public static class CardInfo{
        private String id;
        private String cardNumber;
    }
    public static CardInfo getFirstCardBalance(){
        return new CardInfo("92df3f1c-a033-48e6-8390-206f6b1f56c0", "5559000000000001");
    }
    public static CardInfo getSecondCardBalance(){
        return new CardInfo("0f3f5c2a-249e-4c3d-8287-09f7a039391d","5559000000000002");
    }
    public static int generateValidAmount(int balance) {
        return new Random().nextInt(balance) + 1;
    }

    public static int generateInvalidAmount(int balance) {
        return Math.abs(balance) + new Random().nextInt(10000);
    }
}