package utils;

import io.qameta.allure.Step;

public class CustomLogStep {
    @Step("{0}")
    public static void logStep(String message) {
    }
}
