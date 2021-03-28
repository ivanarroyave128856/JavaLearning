package flightreservationsystem.models;

import java.math.BigDecimal;

public class TechnicalFlightDetails {
    private String technicalConfigurationId;

    private short numberOfEconomicSeatClass;
    private BigDecimal priceForEconomicSeatClass;
    private short numberOfEconomicSeatClassForSmokers;
    private BigDecimal economicSmokerTax;

    private short numberOfPremiumSeatClass;
    private BigDecimal priceForPremiumSeatClass;
    private short numberOfPremiumSeatClassForSmokers;
    private BigDecimal premiumSmokerTax;

    private short seatsTotal;

    public String getTechnicalConfigurationId() {
        return technicalConfigurationId;
    }

    public void setTechnicalConfigurationId(String technicalConfigurationId) {
        this.technicalConfigurationId = technicalConfigurationId;
    }

    public short getNumberOfEconomicSeatClass() {
        return numberOfEconomicSeatClass;
    }

    public void setNumberOfEconomicSeatClass(short numberOfEconomicSeatClass) {
        this.numberOfEconomicSeatClass = numberOfEconomicSeatClass;
    }

    public BigDecimal getPriceForEconomicSeatClass() {
        return priceForEconomicSeatClass;
    }

    public void setPriceForEconomicSeatClass(BigDecimal priceForEconomicSeatClass) {
        this.priceForEconomicSeatClass = priceForEconomicSeatClass;
    }

    public short getNumberOfEconomicSeatClassForSmokers() {
        return numberOfEconomicSeatClassForSmokers;
    }

    public void setNumberOfEconomicSeatClassForSmokers(short numberOfEconomicSeatClassForSmokers) {
        this.numberOfEconomicSeatClassForSmokers = numberOfEconomicSeatClassForSmokers;
    }

    public BigDecimal getEconomicSmokerTax() {
        return economicSmokerTax;
    }

    public void setEconomicSmokerTax(BigDecimal economicSmokerTax) {
        this.economicSmokerTax = economicSmokerTax;
    }

    public short getNumberOfPremiumSeatClass() {
        return numberOfPremiumSeatClass;
    }

    public void setNumberOfPremiumSeatClass(short numberOfPremiumSeatClass) {
        this.numberOfPremiumSeatClass = numberOfPremiumSeatClass;
    }

    public BigDecimal getPriceForPremiumSeatClass() {
        return priceForPremiumSeatClass;
    }

    public void setPriceForPremiumSeatClass(BigDecimal priceForPremiumSeatClass) {
        this.priceForPremiumSeatClass = priceForPremiumSeatClass;
    }

    public short getNumberOfPremiumSeatClassForSmokers() {
        return numberOfPremiumSeatClassForSmokers;
    }

    public void setNumberOfPremiumSeatClassForSmokers(short numberOfPremiumSeatClassForSmokers) {
        this.numberOfPremiumSeatClassForSmokers = numberOfPremiumSeatClassForSmokers;
    }

    public BigDecimal getPremiumSmokerTax() {
        return premiumSmokerTax;
    }

    public void setPremiumSmokerTax(BigDecimal premiumSmokerTax) {
        this.premiumSmokerTax = premiumSmokerTax;
    }

    public short getSeatsTotal() {
        return seatsTotal;
    }

    public void setSeatsTotal(short seatsTotal) {
        this.seatsTotal = seatsTotal;
    }

    public TechnicalFlightDetails() {
    }

    public TechnicalFlightDetails(String technicalConfigurationId, short numberOfEconomicSeatClass,
                                  BigDecimal priceForEconomicSeatClass, short numberOfEconomicSeatClassForSmokers,
                                  BigDecimal economicSmokerTax, short numberOfPremiumSeatClass,
                                  BigDecimal priceForPremiumSeatClass, short numberOfPremiumSeatClassForSmokers,
                                  BigDecimal premiumSmokerTax, short seatsTotal) {
        this.technicalConfigurationId = technicalConfigurationId;
        this.numberOfEconomicSeatClass = numberOfEconomicSeatClass;
        this.priceForEconomicSeatClass = priceForEconomicSeatClass;
        this.numberOfEconomicSeatClassForSmokers = numberOfEconomicSeatClassForSmokers;
        this.economicSmokerTax = economicSmokerTax;
        this.numberOfPremiumSeatClass = numberOfPremiumSeatClass;
        this.priceForPremiumSeatClass = priceForPremiumSeatClass;
        this.numberOfPremiumSeatClassForSmokers = numberOfPremiumSeatClassForSmokers;
        this.premiumSmokerTax = premiumSmokerTax;
        this.seatsTotal = seatsTotal;
    }
}
