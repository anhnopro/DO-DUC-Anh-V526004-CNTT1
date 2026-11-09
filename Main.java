import java.util.ArrayList;
import java.util.Scanner;

// Lớp cơ sở Nguoi
class Nguoi {
    protected String hoTen;
    protected int tuoi;

    public Nguoi() {}

    public Nguoi(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhập họ tên: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        tuoi = sc.nextInt();
        sc.nextLine(); // Xử lý trôi dòng sau khi nhập số nguyên
    }

    public void xuat() {
        System.out.print("Họ tên: " + hoTen + ", Tuổi: " + tuổi);
    }
}

// Lớp NhanVien kế thừa từ lớp Nguoi
class NhanVien extends Nguoi {
    private int snct; // Số năm công tác
    private double hsl; // Hệ số lương

    public NhanVien() {
        super();
    }

    public NhanVien(String hoTen, int tuoi, int snct, double hsl) {
        super(hoTen, tuoi);
        this.snct = snct;
        this.hsl = hsl;
    }

    public int getSnct() {
        return snct;
    }

    public double getHsl() {
        return hsl;
    }

    // Tính tiền lương: tienluong = lcb * hsl + phucap
    // lcb = 1.5 triệu, phucap = 0.2 triệu * snct
    public double tinhTienLuong() {
        double lcb = 1500000;
        double phucap = 200000 * snct;
        return lcb * hsl + phucap;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); // Gọi phương thức nhập của lớp Nguoi
        System.out.print("Nhập số năm công tác: ");
        snct = sc.nextInt();
        System.out.print("Nhập hệ số lương: ");
        hsl = sc.nextDouble();
        sc.nextLine(); // Xử lý trôi dòng sau khi nhập số thực
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(", Số năm công tác: %d, Hệ số lương: %.2f, Tiền lương: %.0f VNĐ\n", 
                snct, hsl, tinhTienLuong());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số lượng nhân viên (n): ");
        int n = sc.nextInt();
        sc.nextLine(); // Xử lý trôi dòng sau khi nhập n

        ArrayList<NhanVien> dsNhanVien = new ArrayList<>();

        // Nhập danh sách n nhân viên từ bàn phím
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập thông tin nhân viên thứ " + (i + 1) + " ---");
            NhanVien nv = new NhanVien();
            nv.nhap(sc);
            dsNhanVien.add(nv);
        }

        // 1. Tìm nhân viên có số năm công tác nhiều nhất
        if (!dsNhanVien.isEmpty()) {
            int maxSnct = dsNhanVien.get(0).getSnct();
            for (NhanVien nv : dsNhanVien) {
                if (nv.getSnct() > maxSnct) {
                    maxSnct = nv.getSnct();
                }
            }

            System.out.println("\n==================================================");
            System.out.println("NHÂN VIÊN CÓ SỐ NĂM CÔNG TÁC NHIỀU NHẤT (" + maxSnct + " năm):");
            for (NhanVien nv : dsNhanVien) {
                if (nv.getSnct() == maxSnct) {
                    nv.xuat();
                }
            }
        }

        // 2. Sắp xếp danh sách nhân viên theo thứ tự lương từ cao đến thấp
        dsNhanVien.sort((o1, o2) -> Double.compare(o2.tinhTienLuong(), o1.tinhTienLuong()));

        System.out.println("\n==================================================");
        System.out.println("DANH SÁCH NHÂN VIÊN SẮP XẾP LƯƠNG TỪ CAO ĐẾN THẤP:");
        for (NhanVien nv : dsNhanVien) {
            nv.xuat();
        }
        
        sc.close();
    }
}