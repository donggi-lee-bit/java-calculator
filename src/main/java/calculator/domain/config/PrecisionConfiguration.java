package calculator.domain.config;

public class PrecisionConfiguration {

    private static final int DEFAULT_PRECISION = 10;

    private int precision;

    public PrecisionConfiguration() {
        this.precision = DEFAULT_PRECISION;
    }

    public int getPrecision() {
        return precision;
    }
}
