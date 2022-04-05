package application;

import java.io.IOException;
import java.util.Objects;

public class ProfitCalculatorApplication {
    public static void main(String[] args) throws IOException {

        ProfitCalculator.calculating((Objects.requireNonNull(InputProcessing.getInformation())));
    }
}
