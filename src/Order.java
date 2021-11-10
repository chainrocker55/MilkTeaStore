// คลาสสำหรับ แสดงข้อมูล order ที่สร้าง
public class Order {
    private String name; //ชื่อเมนู
    private int price; //ราคารวม
    private boolean topping; //ส่วนเสริม
    private int num; //จำนวนแก้วที่สั่ง

    // overloading class ที่ไม่ต้องใส่ parameter
    public Order() {
    }

    //overloading class โดยมี parameter 3 ตัว
    public Order(String name, int price, boolean topping, int num) {
        this.name = name;
        this.price = price;
        this.topping = topping;
        this.num = num;
    }

    //getter and setter ของ ข้อมูล
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isTopping() {
        return topping;
    }

    public void setTopping(boolean topping) {
        this.topping = topping;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    //แสดงรายละเอียดของ order
    public void showOrder(){
        System.out.println("เมนู: "+name);
        System.out.println("ราคา: "+price);
        System.out.println("จำนวน: "+num);
        System.out.println("ใส่ topping: "+topping);
        System.out.println("----------------------");
    }
}
