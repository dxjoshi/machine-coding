package parkingLot.models;

public class Vehicle {
    public enum Type {
        BIKE("BIKE"), CAR("CAR"), TRUCK("TRUCK");
        String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Type getType(String name) {
            Type result = CAR;
            switch (name) {
                case "BIKE":
                    result = Type.BIKE;
                    break;
                case "CAR":
                    result = Type.CAR;
                    break;
                case "TRUCK":
                    result = Type.TRUCK;
                    break;
            }
            return result;
        }
    }
    private final Type type;
    private final String registrationId;
    private final String color;

    public Vehicle(Type type, String registrationId, String color) {
        this.type = type;
        this.registrationId = registrationId;
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getColor() {
        return color;
    }
}
