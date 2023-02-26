package Mortgage;

public class Users {

    /*

        User Class, HousePrices Class ının ebeveyn classidir.

        her bir User in almasi gereken attribute lar private olmalıdır ve su sekildedir:

        String olanlar -> username, whichCondtiton, houseType
        int olanlar -> roomCount, downPayment, longTerm

        ve son olarakta StatesTax cinsinden bir StatesTax olmalıdır:

        "private StatexTax statesTax;"


     */

    //--------------------------------------------------------------
    // -> Attributes

    private String username, whichCondtiton, houseType;
    private int roomCount, downPayment, longTerm;
    private StatesTax statesTax;

    //--------------------------------------------------------------




    /*

        Bir constructor methodu oluşturup, tüm attribute lar constructorda gelmeli ve daha sonra sınıfın kendi attributelarına
    eşitlenmelidir.

     */

    //--------------------------------------------------------------
    // -> Constructor

    public Users(String username, String whichCondtiton, String houseType, int roomCount, int downPayment, int longTerm, StatesTax statesTax) {
        this.username = username;
        this.whichCondtiton = whichCondtiton;
        this.houseType = houseType;
        this.roomCount = roomCount;
        this.downPayment = downPayment;
        this.longTerm = longTerm;
        this.statesTax = statesTax;
    }


    //--------------------------------------------------------------






    // Son olarak ise tüm attributelar icin sadece getter methodlar oluşmalıdır.

    //--------------------------------------------------------------
    // -> Methods

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWhichCondtiton() {
        return whichCondtiton;
    }

    public void setWhichCondtiton(String whichCondtiton) {
        this.whichCondtiton = whichCondtiton;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(int downPayment) {
        this.downPayment = downPayment;
    }

    public int getLongTerm() {
        return longTerm;
    }

    public void setLongTerm(int longTerm) {
        this.longTerm = longTerm;
    }

    public StatesTax getStatesTax() {
        return statesTax;
    }

    public void setStatesTax(StatesTax statesTax) {
        this.statesTax = statesTax;
    }


    //--------------------------------------------------------------
}

