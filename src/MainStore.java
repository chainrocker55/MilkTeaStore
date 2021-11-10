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
