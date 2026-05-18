package pbo;

public class PBO {
    public static void main(String[] args) {
        // Tambah user default untuk testing
        Register.userDatabase.put("admin", "Admin123!");

        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}