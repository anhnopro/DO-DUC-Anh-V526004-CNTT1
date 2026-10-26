import java.util.Scanner;

public class Bai1_P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== BÀI TẬP 1 - PHẦN 1: THAO TÁC TRÊN 2 PHÂN SỐ ===");

        try {
            System.out.print("Nhập tử số phân số 1: ");
            int t1 = scanner.nextInt();
            System.out.print("Nhập mẫu số phân số 1: ");
            int m1 = scanner.nextInt();
            PhanSo ps1 = new PhanSo(t1, m1);

            System.out.print("Nhập tử số phân số 2: ");
            int t2 = scanner.nextInt();
            System.out.print("Nhập mẫu số phân số 2: ");
            int m2 = scanner.nextInt();
            PhanSo ps2 = new PhanSo(t2, m2);

            System.out.println("\n--- KẾT QUẢ ---");
            System.out.println("Phân số 1 (đã rút gọn): " + ps1);
            System.out.println("Phân số 2 (đã rút gọn): " + ps2);

            System.out.println("Tổng (ps1 + ps2) = " + ps1.cong(ps2));
            System.out.println("Hiệu (ps1 - ps2) = " + ps1.tru(ps2));
            System.out.println("Tích (ps1 * ps2) = " + ps1.nhan(ps2));
            try {
                System.out.println("Thương (ps1 / ps2) = " + ps1.chia(ps2));
            } catch (ArithmeticException e) {
                System.out.println("Thương: " + e.getMessage());
            }

            int compare = ps1.soSanh(ps2);
            if (compare > 0) {
                System.out.println("Phân số 1 LỚN HƠN Phân số 2");
            } else if (compare < 0) {
                System.out.println("Phân số 1 NHỎ HƠN Phân số 2");
            } else {
                System.out.println("Phân số 1 BẰNG Phân số 2");
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
