public class PhanSo {
    private int tuSo;
    private int mauSo;

    // Hàm tạo mặc định
    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    // Hàm tạo có đối số
    public PhanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0!");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        rutGon();
    }

    // Getters và Setters
    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0!");
        }
        this.mauSo = mauSo;
    }

    // Tìm ước số chung lớn nhất (UCLN)
    private int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Rút gọn phân số
    public void rutGon() {
        if (mauSo == 0) return;
        int gcd = ucln(tuSo, mauSo);
        tuSo /= gcd;
        mauSo /= gcd;
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }

    // Tính tổng 2 phân số
    public PhanSo cong(PhanSo ps) {
        int ts = this.tuSo * ps.mauSo + ps.tuSo * this.mauSo;
        int ms = this.mauSo * ps.mauSo;
        return new PhanSo(ts, ms);
    }

    // Tính hiệu 2 phân số
    public PhanSo tru(PhanSo ps) {
        int ts = this.tuSo * ps.mauSo - ps.tuSo * this.mauSo;
        int ms = this.mauSo * ps.mauSo;
        return new PhanSo(ts, ms);
    }

    // Tính tích 2 phân số
    public PhanSo nhan(PhanSo ps) {
        int ts = this.tuSo * ps.tuSo;
        int ms = this.mauSo * ps.mauSo;
        return new PhanSo(ts, ms);
    }

    // Tính thương 2 phân số
    public PhanSo chia(PhanSo ps) {
        if (ps.tuSo == 0) {
            throw new ArithmeticException("Không thể chia cho phân số có giá trị 0!");
        }
        int ts = this.tuSo * ps.mauSo;
        int ms = this.mauSo * ps.tuSo;
        return new PhanSo(ts, ms);
    }

    // So sánh 2 phân số (-1: nhỏ hơn, 0: bằng nhau, 1: lớn hơn)
    public int soSanh(PhanSo ps) {
        long val1 = (long) this.tuSo * ps.mauSo;
        long val2 = (long) ps.tuSo * this.mauSo;
        return Long.compare(val1, val2);
    }

    // Kiểm tra có phải số nguyên không (vd: 4/2, 3/1, 0/5)
    public boolean isSoNguyen() {
        return tuSo % mauSo == 0;
    }

    // Giá trị thực dưới dạng double
    public double toDouble() {
        return (double) tuSo / mauSo;
    }

    @Override
    public String toString() {
        if (mauSo == 1) return String.valueOf(tuSo);
        if (tuSo == 0) return "0";
        return tuSo + "/" + mauSo;
    }
}
