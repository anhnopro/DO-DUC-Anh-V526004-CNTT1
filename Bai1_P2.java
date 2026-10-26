import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1_P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== BÀI TẬP 1 - PHẦN 2: THAO TÁC TRÊN TẬP HỢP PHÂN SỐ ===");

        System.out.print("Nhập số lượng phân số trong tập hợp: ");
        int n = scanner.nextInt();

        List<PhanSo> danhSach = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phân số thứ " + (i + 1) + ":");
            while (true) {
                try {
                    System.out.print("  - Tử số: ");
                    int tu = scanner.nextInt();
                    System.out.print("  - Mẫu số: ");
                    int mau = scanner.nextInt();
                    danhSach.add(new PhanSo(tu, mau));
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại!");
                }
            }
        }

        if (danhSach.isEmpty()) {
            System.out.println("Danh sách phân số trống!");
            return;
        }

        System.out.println("\n--- DANH SÁCH PHÂN SỐ ĐÃ NHẬP ---");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println("Phân số " + (i + 1) + ": " + danhSach.get(i));
        }

        // 1. Tìm phân số lớn nhất
        PhanSo maxPS = danhSach.get(0);
        for (int i = 1; i < danhSach.size(); i++) {
            if (danhSach.get(i).soSanh(maxPS) > 0) {
                maxPS = danhSach.get(i);
            }
        }
        System.out.println("\n1. Phân số lớn nhất trong tập hợp: " + maxPS);

        // 2. Tính tổng các phân số
        PhanSo tongPS = new PhanSo(0, 1);
        for (PhanSo ps : danhSach) {
            tongPS = tongPS.cong(ps);
        }
        System.out.println("2. Tổng các phân số trong tập hợp: " + tongPS);

        // 3. Xác định các phân số KHÔNG PHẢI số nguyên
        System.out.println("3. Danh sách các phân số KHÔNG PHẢI số nguyên:");
        int countKhongNguyen = 0;
        for (PhanSo ps : danhSach) {
            if (!ps.isSoNguyen()) {
                System.out.println("   - " + ps);
                countKhongNguyen++;
            }
        }
        if (countKhongNguyen == 0) {
            System.out.println("   (Không có phân số nào, tất cả đều là số nguyên)");
        } else {
            System.out.println("   -> TỔNG CỘNG CÓ: " + countKhongNguyen + " phân số không phải số nguyên.");
        }
    }
}
