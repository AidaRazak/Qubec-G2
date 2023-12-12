import javax.swing.*;
import java.awt.*;

public class ChessBoardGUI extends JFrame {

    private JPanel chessBoard;
    private JButton[][] squares = new JButton[6][7];

    public ChessBoardGUI() {
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Chess Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        chessBoard = new JPanel(new GridLayout(6, 7));
        chessBoard.setPreferredSize(new Dimension(600, 600));
        add(chessBoard);

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                squares[row][col] = new JButton();
                squares[row][col].setOpaque(true);
                squares[row][col].setBorderPainted(false);

                if ((row + col) % 2 == 0) {
                    squares[row][col].setBackground(Color.WHITE);
                } else {
                    squares[row][col].setBackground(Color.BLACK);
                }

                chessBoard.add(squares[row][col]);
            }
        }

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessBoardGUI chessBoardGUI = new ChessBoardGUI();
            chessBoardGUI.setVisible(true);
        });
    }
}
