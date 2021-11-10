/*
   เป็นคลาสสำหรับ "ร้านชานมไข้มุข" สามารถคิดราคาและสร้าง order โดยร้านจะต้องตั้งชื่อร้านก่อนเปิดร้าน และมี
   - เมนู "Coco", "Milk", "Matcha", "Chocolate", "Chocolate", "Caramel"
   - ชื่อสาขา (branchName)
   - ยอดเงินตั้งต้น (balance) เป็น 0
   - จำนวนแก้ว (glass)
   - ผงชานม (powder)
 */
public class MilkTeaStore {
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
