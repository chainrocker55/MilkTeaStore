package sumclass;

public class MainStore {
    //method main สำหรับเรียกการใช้งาน
    public static void main(String[] args) {
        //สร้างร้านชานมโดยใส่แค่ ชื่อร้าน
        MilkTeaStore milkTeaStore1 = new MilkTeaStore("ร้านนมสดใส");
        //สร้างร้านชานมโดยใส่แค่ ชื่อร้าน และจำนวนแก้ว
        MilkTeaStore milkTeaStore2 = new MilkTeaStore("ร้านนมลีลา", 50);
        //สร้างร้านชานมโดยใส่แค่ ชื่อร้าน และจำนวนผงชานม
        MilkTeaStore milkTeaStore3 = new MilkTeaStore("ร้านนมวิลล่า", 200.0);
        //สร้างร้านชานมโดยใส่แค่ ชื่อร้าน จำนวนแก้วและจำนวนผงชานม
        MilkTeaStore milkTeaStore4 = new MilkTeaStore("ร้านนมวอนวอน", 30, 200.0);

        //สั่ง order Coco
        milkTeaStore2.order("Coco", 1);
        //ทำการแสดงคลังสินค้าโดยจะเห็นจำนวนแก้วและ ผงชานมลดลง
        milkTeaStore2.showStock();

        //สั่ง order Milk
        milkTeaStore1.order("Milk");// จำนวนแก้วจะเท่ากับ 1 และ ไม่ใส่ topping
        milkTeaStore1.order("Milk", 1); //จำนวนแก้วจะเท่ากับ 1 และ ไม่ใส่ topping
        milkTeaStore1.order("Milk", 1, true); //จะเห็นราตาเพิ่มขึ้นอีก 5 บาท
        milkTeaStore1.order("Milk",true);//จะเห็นราตาเพิ่มขึ้นอีก 5 บาท
        milkTeaStore1.order("Milk", 2); //จะเห็นราตาเพิ่มขึ้นสองเท่าเพราะ สั่งสองแก้ว


        //ทำการแสดงคลังสินค้า โดยจะเห็นจำนวนแก้วและ ผงชานมลดลง
        milkTeaStore1.showStock();


        //สั่ง order ที่ไม่มีในร้านค้า
        milkTeaStore4.order("ThaiMilk", 1);
        //ทำการแสดงคลังสินค้า โดยจะเห็นจำนวนแก้วและ ผงชานมเท่าเดิม
        milkTeaStore4.showStock();


        //เรียกใช้ get and set ใน class
        milkTeaStore1.setGlass(0);
        System.out.println("จำนวนแก้วตือ : "+milkTeaStore1.getGlass());


        //สินค้าไม่พอใน stock
        MilkTeaStore milkTeaStore5 = new MilkTeaStore("ร้านนมแมว", 0, 200.0);
        //ทดลอง สั่ง order แสดงข้อความ "Sorry product is not enough"
        milkTeaStore5.order("Milk");// จำนวนแก้วจะเท่ากับ 1 และ ไม่ใส่ topping



    }

}
class MilkTeaStore {
    private String branchName; // ชื่อสาขา
    private int balance; // ยอดเงิน
    private int glass; // จำนวนแก้ว
    private double powder; //จำนวนผงชานม

    // overloading class 1
    // ตั้งชื่อร้าน โดยจำนวนแก้วคือ 20 และ ผงชานมคือ 100.0
    // โดยจะเรียก overloading 4
    public MilkTeaStore(String branchName) {
        this(branchName, 20, 100.0);
    }
    // overloading class 2
    // ตั้งชื่อร้านและจำนวนแก้ว โดยจำนวนแก้วตาม user และ ผงชานมคือ 100.0
    // โดยจะเรียก overloading 4
    public MilkTeaStore(String branchName, int glass) {
        this(branchName, glass, 100.0);
    }
    // overloading class 3
    // ตั้งชื่อร้านและจำนวนผงชานม โดยจำนวนผงชานมตาม user และ จำนวนแก้วคือ 20
    // โดยจะเรียก overloading ต่อไป
    public MilkTeaStore(String branchName, double powder) {
        this(branchName,20, powder);
    }
    // overloading class 4
    // ตั้งชื่อร้านและจำนวนผงชานม โดยจำนวนผงชานมและจำนวนแก้วตาม user
    public MilkTeaStore(String branchName, int glass, double powder) {
        this.branchName = branchName;
        this.glass = glass;
        this.powder = powder;
        this.balance = 0;

        //แสดงข้อความเมื่อสร้างร้านค้าเสร็จ
        this.showStock();
    }

    // getter and setter
    // สามารถเรียกใช้จากภายนอกได้
    //get ชื่อร้าน
    public String getBranchName() {
        return branchName;
    }
    //set ชื่อร้าน
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    //get จำนวนแก้ว
    public int getGlass() {
        return glass;
    }
    //set จำนวนแก้ว
    public void setGlass(int glass) {
        this.glass = glass;
    }
    //get จำนวนผงชานม
    public double getPowder() {
        return powder;
    }
    //set จำนวนผงชานม
    public void setPowder(double powder) {
        this.powder = powder;
    }
    //get ยอดเงินของร้าน โดยสามารถ get ได้อย่างเดียว
    public int getBalance() {
        return balance;
    }
    //แสดงข้อความจำนวนคงเหลือของสินค้าในร้านค้าและยอดเงิน
    public void showStock(){
        System.out.println("ชื่อร้าน: " +branchName);
        System.out.println("จำนวนแก้ว: " +glass);
        System.out.println("จำนวนผง: " +powder);
        System.out.println("ยอดเงิน: " +balance);
        System.out.println("----------------------");
    }

    //overloading function order 1 เรียก overloading order 4
    //เป็นการสั่ง order โดยไม่ระบุอะไรมา
    public void order(String menu){
        this.order(menu, 1, false);
    }

    //overloading function order 2 เรียก overloading order 4
    //เป็นการสั่ง order และระบุจำนวนแก้ว
    public void order(String menu, int num){
        this.order(menu, num, false);
    }

    //overloading function order 3 เรียก overloading order 4
    //เป็นการสั่ง order และระบุ topping
    public void order(String menu, boolean topping){
        this.order(menu, 1, topping);
    }
    //overloading function order 4
    //เป็นการสั่ง order โดยระบุ จำนวนแก้วและ topping
    public void order(String menu, int num, boolean topping){
        //เช็คว่า สินค้าเหลือพอหรือไม่
        if(powder*num <=8 || glass < num){
            System.out.println("Sorry product is not enough");
            return;
        }
        //แสดงว่าสั่ง menu อะไรมากี่แก้ว และ ใส่ topping หรือไม่
        System.out.println("รับ order : "+ menu + " "+num+ " แก้ว ใส่ topping: "+ topping);
        int price = 0;
        //check ถ้าใส่ topping จะคิดเงิน เพื่ม 5 บาท
        if(topping){
            price = price + 5;
        }
        //เช็คว่ามีเมนูในร้านหรือไม่หากมีแล้วจะทำการบวกราคาเพิ่มและ ทำการสร้าง
        if(menu.equals("Coco")){
            price = price + 35;
            this.make(12.5, num);
        }else if(menu.equals("Milk")){
            price = price + 25;
            this.make(8, num);
        }else if(menu.equals("Matcha")){
            price = price + 45;
            this.make(15, num);
        }else if(menu.equals("Chocolate")){
            price = price + 30;
            this.make(11, num);
        }else if(menu.equals("Caramel")){
            price = price + 40;
            this.make(13.5, num);
        }else{ // หากไม่มี menu นั้น จะทำการแสดงข้อความ และ หยุดการทำงาน
            System.out.println("Sorry, we don't have that menu "+menu);
            return;
        }
        //ทำการคเก็บเงินและเพื่มยอด balance โดยส่งราคาเป็น parameter
        this.calculate(price);

        //สร้าง order จาก constructor โดยส่ง parameter 3 ตัว
        Order order = new Order(menu, price * num, topping, num);
        //แสดงข้อความเมื่อ สร้าง order เสร็จแล้ว
        order.showOrder();
    }

    //function สร้าง ชานมตามจำนวนและ ทำการ ลดค่า powder ตามจำนวนแก้ว
    private void make(double powder, int num){
        this.powder = this.powder - (powder * num);
        this.glass = this.glass - num;
    }
    //function ในการคิดเงินและเพิ่มยอด balance
    private void calculate(int price){
        this.balance = balance + price;
    }

}
class Order {
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
