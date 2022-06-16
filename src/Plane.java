import java.io.Serializable;

public class Plane implements Serializable {
    private float fuelLevel;
    private String pilotCallSign;
    private String squadNumber;

    private boolean flaps = true;
    String flapsStatus;
    private boolean landingGear = true;
    String landingGearStatus;
    private boolean ejectionSystem = false;
    String ejectionSystemStatus = "Desarmado";

    private boolean seatOccupation = true;
    String seatOccupationStatus = "Verdadero";

    public Plane(float fuelLevel, String pilotCallSign, String squadNumber) {
        this.fuelLevel = fuelLevel;
        this.pilotCallSign = pilotCallSign;
        this.squadNumber = squadNumber;

        // Completa el código para cumplir con los requisitos.
    }

    public void toggleFlaps() {
        flaps = !flaps;
        if (flaps == true) {
            flapsStatus = "Arriba";
        } else {
            flapsStatus = "Abajo";
        }
    }

    public void toggleLandingGear() {
        landingGear = !landingGear;
        if (landingGear == true) {
            landingGearStatus = "Abajo";
        } else {
            landingGearStatus = "Abajo";
        }
    }

    public void ejectionSystem() {
        ejectionSystem = !ejectionSystem;
        if (ejectionSystem == true) {
            ejectionSystemStatus = "Armado";
        } else {
            ejectionSystemStatus = "Desarmado";
        }
    }

    public boolean isEjectionSystem() {
        return ejectionSystem;
    }

    public void setSeatOccupation(boolean pilotSeated) {
        seatOccupation = pilotSeated;
        if (seatOccupation == false) {
            seatOccupationStatus = "Falso";
        }
    }

    public boolean isFlaps() {
        return flaps;
    }

    public boolean isLandingGear() {
        return landingGear;
    }

    @Override
    public String toString() {
        return "Plane{" + "\n" +
                "fuelLevel=" + fuelLevel + "\n" +
                "pilotCallSign='" + pilotCallSign + "\n" +
                "squadNumber='" + squadNumber + "\n" +
                "flaps=" + flapsStatus + "\n" +
                "landingGear=" + landingGearStatus + "\n" +
                "ejectionSystem=" + ejectionSystemStatus + "\n" +
                "seatOccupation=" + seatOccupationStatus + "\n" +
                '}';
    }
}
