package sample.models;

public class TransportModel {

    private static String id;
    private static String brand;
    private static String model;
    private static String category;
    private static String number;
    private static String type;
    private static String date;
    private static String trailer;

    public TransportModel() {
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        TransportModel.id = id;
    }

    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String brand) {
        TransportModel.brand = brand;
    }

    public static String getModel() {
        return model;
    }

    public static void setModel(String model) {
        TransportModel.model = model;
    }

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        TransportModel.category = category;
    }

    public static String getNumber() {
        return number;
    }

    public static void setNumber(String number) {
        TransportModel.number = number;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        TransportModel.type = type;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        TransportModel.date = date;
    }

    public static String getTrailer() {
        return trailer;
    }

    public static void setTrailer(String trailer) {
        TransportModel.trailer = trailer;
    }
}
