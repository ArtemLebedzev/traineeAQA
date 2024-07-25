public class Park {
    private String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double price;

        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Park name:'" + parkName + '\'' +
                    ", attraction name:'" + attractionName + '\'' +
                    ", workingHours:'" + workingHours + '\'' +
                    ", price:" + price;
        }
    }
}
