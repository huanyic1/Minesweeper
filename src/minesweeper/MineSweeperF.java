/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import static minesweeper.Game.ArrayDisplay;
import static minesweeper.Game.fillSquares;
import static minesweeper.Game.generateMines;

/**
 *
 * @author DELL
 */
public class MineSweeperF extends javax.swing.JFrame implements ActionListener {

    JButton[][] butArray = new JButton[25][25];
    boolean first = true; //keeps track of whether it is first or second button clicked
    boolean flag = false;
    static int numMines; //variable to determine number of matches
    String[][] board; //array of ints to represent board
    int level = 0;
    int flagCount = 0;
    static int numFlags = 69;
    static int size=15; 

    /**
     * Creates new form MatchingFrame
     */
    public MineSweeperF() {
        initComponents();
       initialize(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GamePanel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NewGame = new javax.swing.JButton();
        Difficulty = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        FlabButton = new javax.swing.JToggleButton();
        FlagField = new javax.swing.JTextField();
        ResultsField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));
        setIconImages(null);
        setSize(new java.awt.Dimension(891, 673));

        GamePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        GamePanel.setFont(new java.awt.Font("Times New Roman", 0, 5)); // NOI18N
        GamePanel.setPreferredSize(new java.awt.Dimension(500, 400));
        GamePanel.setLayout(new java.awt.GridLayout(8, 8));

        Title.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Minesweeper");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Flag");

        NewGame.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        NewGame.setText("New Game");
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });

        Difficulty.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Difficulty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Level 1", "Level 2", "Level 3" }));
        Difficulty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DifficultyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Level");

        FlabButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        FlabButton.setText("Off");
        FlabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlabButtonActionPerformed(evt);
            }
        });

        FlagField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        FlagField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FlagField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlagFieldActionPerformed(evt);
            }
        });

        ResultsField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ResultsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultsFieldActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/RedFlag.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/mine.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/mine.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(GamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ResultsField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FlagField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FlabButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Difficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Difficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(FlabButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FlagField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ResultsField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(GamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
     
        board = CreateBoard(level); //creates the board that the player will be playing on
        first = true;
        flag = false;
        ResultsField.setText("");
        for (int r1 = 0; r1 < size; r1++) {
            for (int c1 = 0; c1 < size; c1++) {
                butArray[r1][c1].setText("");
                butArray[r1][c1].setBackground(new Color(0, 125, 0));
            }
        }
        flagCount=0; 
         FlabButton.setText("Off");
         
        FlagField.setText(Integer.toString(numFlags));
 
    }//GEN-LAST:event_NewGameActionPerformed

    private void DifficultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DifficultyActionPerformed
    clear(); 
     
        level = Difficulty.getSelectedIndex(); 
       if(level==0)
         
          GamePanel.setLayout(new GridLayout(8, 8));
       if(level==1)
          GamePanel.setLayout(new GridLayout(10, 10));
       if(level==2)
          GamePanel.setLayout(new GridLayout(15, 15));
       
   initialize();
    }//GEN-LAST:event_DifficultyActionPerformed

    private void FlabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlabButtonActionPerformed

        if (flagCount % 2 == 0) {
            flag = true;
            FlabButton.setText("On");
        } else {
            flag = false;
            FlabButton.setText("Off");
        }
        flagCount++;
    }//GEN-LAST:event_FlabButtonActionPerformed

    private void FlagFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlagFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FlagFieldActionPerformed

    private void ResultsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResultsFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MineSweeperF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MineSweeperF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MineSweeperF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MineSweeperF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MineSweeperF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Difficulty;
    private javax.swing.JToggleButton FlabButton;
    private javax.swing.JTextField FlagField;
    private javax.swing.JPanel GamePanel;
    private javax.swing.JButton NewGame;
    private javax.swing.JTextField ResultsField;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
public void initialize() {
     board = CreateBoard(level); //creates the board that the player will be playing on
        FlagField.setText(Integer.toString(numFlags));
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                butArray[r][c] = new JButton(); //creates an array of buttons
                butArray[r][c].addActionListener(this);
                butArray[r][c].setSize(30, 30);
                butArray[r][c].setBackground(new Color(0, 125, 0)); //sets default color to white
                butArray[r][c].setText(" "); // sets default display to spaces
                GamePanel.add(butArray[r][c]);
        
            }
        }

       
    }
public void clear(){
     for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                 GamePanel.remove(butArray[r][c]); 
            }
            }
}
    @Override
    public void actionPerformed(ActionEvent ae) {

        for (int r = 0; r <size; r++) {
            for (int c = 0; c < size; c++) {

                if (ae.getSource() == butArray[r][c]) {

                    if (first == true) {
                        while (true) {
                            if (board[r][c].equals("0")) {
                              
                                first = false;
                                break;
                            } else {
                                board = CreateBoard(level);
                            }
                        }
                    }
                    if (flag == true) {
                        if (butArray[r][c].getText().equals("!")) {
                            butArray[r][c].setText(" ");
                            butArray[r][c].setBackground(new Color(0, 125, 0));
                            numFlags++;
                            FlagField.setText(Integer.toString(numFlags));
                        } else {
                            butArray[r][c].setText("!");
                            butArray[r][c].setBackground(new Color(200, 0, 0));
                            numFlags--;
                            FlagField.setText(Integer.toString(numFlags));
                        }
                    } else {

                        String SpotsOpened = open(board, r, c);
                       int[][] coordinates = positions(SpotsOpened);
                        for (int i = 0; i < coordinates.length; i++) {

                            butArray[coordinates[i][0]][coordinates[i][1]].setText(board[coordinates[i][0]][coordinates[i][1]]);
                            butArray[coordinates[i][0]][coordinates[i][1]].setBackground(new Color(240, 240, 240));
                        }
                        int Opened = 0;
                        Color d = new Color(240, 240, 240);

                        for (int r1 = 0; r1 < size; r1++) {
                            for (int c1 = 0; c1 < size; c1++) {
                                Color m = butArray[r1][c1].getBackground();
                                if (!butArray[r1][c1].getText().equals("!") && m.equals(d)) {
                                    Opened++;

                                }
                            }
                        }

                        if (Opened == (board.length) * (board[0].length) - numMines) {
                            for (int r1 = 0; r1 < size; r1++) {
                                for (int c1 = 0; c1 < size; c1++) {
                                    if(board[r1][c1].equals("0")){
                                         butArray[r1][c1].setText(""); 
                                    }
                                    else{
                                    butArray[r1][c1].setText(board[r1][c1]);
                                    }
                                    if(board[r1][c1].equals("X")){
                                    butArray[r1][c1].setBackground(new Color(200, 0, 0));
                                    }
                                    else{
                                      butArray[r1][c1].setBackground(new Color(240, 240, 240));   
                                    }
                                    }
                            }
                            ResultsField.setText("You won!");
                        }
                        // }
                        if (board[r][c].equals("X")) {
                            for (int r1 = 0; r1 < size; r1++) {
                                for (int c1 = 0; c1 < size; c1++) {
                                    if(board[r1][c1].equals("0")){
                                         butArray[r1][c1].setText(""); 
                                    }
                                    else{
                                    butArray[r1][c1].setText(board[r1][c1]);
                                    }
                                     if(board[r1][c1].equals("X")){
                                    butArray[r1][c1].setBackground(new Color(200, 0, 0));
                                    }
                                    else{
                                      butArray[r1][c1].setBackground(new Color(240, 240, 240));   
                                    }
                                    
                            
                                }
                            }
                            ResultsField.setText("You lost!");
                        }
                    }

                }

            }

        }

    }

    public static String[][] CreateBoard(int difficulty) {
        int s = 0;
        int numberMines = 0;
        if (difficulty == 0) {
            s = 8;
            numberMines = 5;
          

        } else if (difficulty == 1) {
            s = 10;
            numberMines = 15;
        } else {
             s = 15;
            numberMines = 25;
           
        }
        String[][] grid = new String[s][s];
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[1].length; b++) {
                grid[a][b] = "O";
            }
        }

        int[][] mines = generateMines(numberMines, s);
        for (int i = 0; i < numberMines; i++) {
            int r = mines[i][0];
            int c = mines[i][1];
            grid[r][c] = "X";
        }

        grid = fillSquares(grid, s);
        numMines = numberMines;
        numFlags = numberMines;
        size=s; 
        return grid;
    }

    public static String[][] fillSquares(String[][] grid, int size) {
        grid = TRCorner(grid, size);
        grid = TLCorner(grid, size);
        grid = BRCorner(grid, size);
        grid = BLCorner(grid, size);
        grid = LEdge(grid, size);
        grid = REdge(grid, size);
        grid = TEdge(grid, size);
        grid = BEdge(grid, size);
        grid = Middle(grid, size);

        return grid;
    }

    public static String[][] TRCorner(String[][] grid, int size) {
        int countC2 = 0;
        if (grid[0][size - 2].equals("X")) {
            countC2++;
        }
        if (grid[1][size - 2].equals("X")) {
            countC2++;
        }
        if (grid[1][size - 1].equals("X")) {
            countC2++;
        }
        if (!grid[0][size - 1].equals("X")) {
            grid[0][size - 1] = Integer.toString(countC2);
        }
        return grid;
    }

    public static String[][] TLCorner(String[][] grid, int size) {
        int countC1 = 0;
        if (grid[0][1].equals("X")) {
            countC1++;
        }
        if (grid[1][1].equals("X")) {
            countC1++;
        }
        if (grid[1][0].equals("X")) {
            countC1++;
        }
        if (!(grid[0][0].equals("X"))) {
            grid[0][0] = Integer.toString(countC1);
        }

        return grid;
    }

    public static String[][] BRCorner(String[][] grid, int size) {
        int countC4 = 0;
        if (grid[size - 1][size - 2].equals("X")) {
            countC4++;
        }
        if (grid[size - 2][size - 2].equals("X")) {
            countC4++;
        }
        if (grid[size - 2][size - 1].equals("X")) {
            countC4++;
        }
        if (!grid[size - 1][size - 1].equals("X")) {
            grid[size - 1][size - 1] = Integer.toString(countC4);
        }

        return grid;
    }

    public static String[][] BLCorner(String[][] grid, int size) {
        int countC3 = 0;
        if (grid[size - 1][1].equals("X")) {
            countC3++;
        }
        if (grid[size - 2][1].equals("X")) {
            countC3++;
        }
        if (grid[size - 2][0].equals("X")) {
            countC3++;
        }
        if (!grid[size - 1][0].equals("X")) {
            grid[size - 1][0] = Integer.toString(countC3);
        }

        return grid;
    }

    public static String[][] LEdge(String[][] grid, int size) {
        for (int i = 1; i < size - 1; i++) {
            int count = 0;
            if (!grid[i][0].equals("X")) {
                if (grid[i - 1][0].equals("X")) {
                    count++;
                }
                if (grid[i + 1][0].equals("X")) {
                    count++;
                }
                if (grid[i][1].equals("X")) {
                    count++;
                }
                if (grid[i + 1][1].equals("X")) {
                    count++;
                }
                if (grid[i - 1][1].equals("X")) {
                    count++;
                }
                grid[i][0] = Integer.toString(count);
            }
        }
        return grid;
    }

    public static String[][] REdge(String[][] grid, int size) {
        for (int i = 1; i < size - 1; i++) {
            int count = 0;
            if (!grid[i][size - 1].equals("X")) {
                if (grid[i - 1][size - 1].equals("X")) {
                    count++;
                }
                if (grid[i + 1][size - 1].equals("X")) {
                    count++;
                }
                if (grid[i][size - 2].equals("X")) {
                    count++;
                }
                if (grid[i + 1][size - 2].equals("X")) {
                    count++;
                }
                if (grid[i - 1][size - 2].equals("X")) {
                    count++;
                }
                grid[i][size - 1] = Integer.toString(count);
            }
        }
        return grid;
    }

    public static String[][] TEdge(String[][] grid, int size) {
        for (int i = 1; i < size - 1; i++) {
            int count = 0;
            if (!grid[0][i].equals("X")) {
                if (grid[0][i - 1].equals("X")) {
                    count++;
                }
                if (grid[0][i + 1].equals("X")) {
                    count++;
                }
                if (grid[1][i - 1].equals("X")) {
                    count++;
                }
                if (grid[1][i + 1].equals("X")) {
                    count++;
                }
                if (grid[1][i].equals("X")) {
                    count++;
                }
                grid[0][i] = Integer.toString(count);
            }
        }
        return grid;
    }

    public static String[][] BEdge(String[][] grid, int size) {
        for (int i = 1; i < size - 1; i++) {
            int count = 0;
            if (!grid[size - 1][i].equals("X")) {
                if (grid[size - 1][i - 1].equals("X")) {
                    count++;
                }
                if (grid[size - 1][i + 1].equals("X")) {
                    count++;
                }
                if (grid[size - 2][i - 1].equals("X")) {
                    count++;
                }
                if (grid[size - 2][i + 1].equals("X")) {
                    count++;
                }
                if (grid[size - 2][i].equals("X")) {
                    count++;
                }
                grid[size - 1][i] = Integer.toString(count);
            }
        }
        return grid;
    }

    public static String[][] Middle(String[][] grid, int size) {
        for (int r = 1; r < size - 1; r++) {
            for (int c = 1; c < size - 1; c++) {
                int count = 0;
                if (!grid[r][c].equals("X")) {
                    if (grid[r - 1][c - 1].equals("X")) {
                        count++;
                    }
                    if (grid[r + 1][c + 1].equals("X")) {
                        count++;
                    }
                    if (grid[r - 1][c + 1].equals("X")) {
                        count++;
                    }
                    if (grid[r + 1][c - 1].equals("X")) {
                        count++;
                    }
                    if (grid[r][c + 1].equals("X")) {
                        count++;
                    }

                    if (grid[r][c - 1].equals("X")) {
                        count++;
                    }
                    if (grid[r + 1][c].equals("X")) {
                        count++;
                    }
                    if (grid[r - 1][c].equals("X")) {
                        count++;
                    }

                    grid[r][c] = Integer.toString(count);
                }
            }
        }
        return grid;
    }

    public static int[][] generateMines(int nMines, int size) { //generates and places mines
        Random r = new Random();
        int[][] mines = new int[nMines][2];
        for (int i = 0; i < nMines; i++) {
            mines[i][0] = -1;
            mines[i][1] = -1;
        }
        for (int n = 0; n < nMines; n++) {
            int a = (int) (size * Math.random());
            int b = (int) (size * Math.random());
            for (int i = 0; i < mines.length; i++) {
                if (a == mines[i][0] && b == mines[i][1]) {//ensures that no two mines placed at same spot
                    n--;
                    break;
                } else if (mines[i][0] == -1 || mines[i][1] == -1) {//checks to make sure spot is empty
                    mines[i][0] = a;
                    mines[i][1] = b;
                    break;
                }
            }

        }
        return mines;
    }

   public static int[][] positions(String s) {
        s += " ";
        int numSpaces = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals(" ")) {
                numSpaces++;
            }
        }
        int spaces[] = new int[numSpaces];
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals(" ")) {
                spaces[p] = i;
                p++;
            }
        }
        int[][] location = new int[numSpaces / 2][2];
        for (int i = 0; i < numSpaces - 1; i++) {
            if ((i) % 2 == 0) {
                location[i / 2][0] = Integer.parseInt(s.substring(spaces[i] + 1, spaces[i + 1]));
            } else {
                location[i / 2][1] = Integer.parseInt(s.substring(spaces[i] + 1, spaces[i + 1]));
            }
        }

        return location;
    }

    public static String open(String[][] b, int r, int c) {
        if (b[r][c] != null && !b[r][c].equals("0")) {
            return " " + Integer.toString(r) + " " + Integer.toString(c);
        }
        if (r == 0 && c == 0) {
            b[r][c] = " ";
            return " " + Integer.toString(r) + " " + Integer.toString(c) + open(b, r + 1, c + 1) + open(b, r, c + 1) + open(b, r + 1, c);
        }
        if (r == 0 && c == b[0].length - 1) {
            b[r][c] = " ";
            return " " + Integer.toString(r) + " " + Integer.toString(c) + open(b, r + 1, c - 1) + open(b, r, c - 1) + open(b, r + 1, c);
        }
        if (r == b.length - 1 && c == b[0].length - 1) {
            b[r][c] = " ";
            return " " + Integer.toString(r) + " " + Integer.toString(c) + open(b, r - 1, c - 1) + open(b, r, c - 1) + open(b, r - 1, c);
        }
        if (r == b.length - 1 && c == 0) {
            b[r][c] = " ";
            return " " + Integer.toString(r) + " " + Integer.toString(c) + open(b, r - 1, c + 1) + open(b, r - 1, c) + open(b, r - 1, c + 1);
        } //if r = b.size-1...if r =0..if c=0, if c=b.size-1... 

        if (r == b.length - 1) {
            b[r][c] = " ";
            return " " + Integer.toString(r) + " " + Integer.toString(c) + open(b, r - 1, c) + open(b, r - 1, c + 1) + open(b, r - 1, c - 1) + open(b, r, c + 1) + open(b, r, c - 1);
        }
        if (c == 0) {
            b[r][c] = " ";
            return " " + Integer.toString(r) + " " + Integer.toString(c) + open(b, r - 1, c) + open(b, r + 1, c) + open(b, r - 1, c + 1) + open(b, r + 1, c + 1) + open(b, r, c + 1);
        }
        if (c == b[0].length - 1) {
            b[r][c] = " ";
            return " " + Integer.toString(r) + " " + Integer.toString(c) + open(b, r - 1, c) + open(b, r + 1, c) + open(b, r - 1, c - 1) + open(b, r + 1, c - 1) + open(b, r, c - 1);
        }

        if (r == 0) {
            b[r][c] = " ";
            return " " + Integer.toString(r) + " " + Integer.toString(c) + open(b, r + 1, c) + open(b, r + 1, c + 1) + open(b, r + 1, c - 1) + open(b, r, c + 1) + open(b, r, c - 1);
        } else {
            b[r][c] = " ";
            return " " + Integer.toString(r) + " " + Integer.toString(c) + open(b, r - 1, c - 1) + open(b, r - 1, c + 1) + open(b, r - 1, c) + open(b, r, c - 1) + open(b, r, c + 1) + open(b, r + 1, c - 1) + open(b, r + 1, c + 1) + open(b, r + 1, c);
            //return Integer.toString(r)+Integer.toString(c) + open(b, r,c-1)+ open(b, r,c+1);
        }
    }
}
