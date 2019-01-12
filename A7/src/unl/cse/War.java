/**Author: James Erickson
 * Dec. 5th, 2018
 * 
 **/
package unl.cse;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.concurrent.ThreadLocalRandom;

public class War extends JFrame {
	
	private final JTextField score = new JTextField("Press the New Cards button to play a game of war!", 20);
	private final JTextField announcer = new JTextField("First to 13 points wins!", 20);
	
	static int playerScore = 0;
	static int computerScore = 0;
	static int reward = 1;

	public War() {
		initializeGUI();
	}
	
	static String[][] cards = new String[13][4];{
		cards[0][0] = "src/cards/ace_of_clubs.png";
		cards[0][1] = "src/cards/ace_of_diamonds.png";
		cards[0][2] = "src/cards/ace_of_hearts.png";
		cards[0][3] = "src/cards/ace_of_spades.png";
		cards[1][0] = "src/cards/2_of_clubs.png";
		cards[1][1] = "src/cards/2_of_diamonds.png";
		cards[1][2] = "src/cards/2_of_hearts.png";
		cards[1][3] = "src/cards/2_of_spades.png";
		cards[2][0] = "src/cards/3_of_clubs.png";
		cards[2][1] = "src/cards/3_of_diamonds.png";
		cards[2][2] = "src/cards/3_of_hearts.png";
		cards[2][3] = "src/cards/3_of_spades.png";
		cards[3][0] = "src/cards/4_of_clubs.png";
		cards[3][1] = "src/cards/4_of_diamonds.png";
		cards[3][2] = "src/cards/4_of_hearts.png";
		cards[3][3] = "src/cards/4_of_spades.png";
		cards[4][0] = "src/cards/5_of_clubs.png";
		cards[4][1] = "src/cards/5_of_diamonds.png";
		cards[4][2] = "src/cards/5_of_hearts.png";
		cards[4][3] = "src/cards/5_of_spades.png";
		cards[5][0] = "src/cards/6_of_clubs.png";
		cards[5][1] = "src/cards/6_of_diamonds.png";
		cards[5][2] = "src/cards/6_of_hearts.png";
		cards[5][3] = "src/cards/6_of_spades.png";
		cards[6][0] = "src/cards/7_of_clubs.png";
		cards[6][1] = "src/cards/7_of_diamonds.png";
		cards[6][2] = "src/cards/7_of_hearts.png";
		cards[6][3] = "src/cards/7_of_spades.png";
		cards[7][0] = "src/cards/8_of_clubs.png";
		cards[7][1] = "src/cards/8_of_diamonds.png";
		cards[7][2] = "src/cards/8_of_hearts.png";
		cards[7][3] = "src/cards/8_of_spades.png";
		cards[8][0] = "src/cards/9_of_clubs.png";
		cards[8][1] = "src/cards/9_of_diamonds.png";
		cards[8][2] = "src/cards/9_of_hearts.png";
		cards[8][3] = "src/cards/9_of_spades.png";
		cards[9][0] = "src/cards/10_of_clubs.png";
		cards[9][1] = "src/cards/10_of_diamonds.png";
		cards[9][2] = "src/cards/10_of_hearts.png";
		cards[9][3] = "src/cards/10_of_spades.png";
		cards[10][0] = "src/cards/jack_of_clubs2.png";
		cards[10][1] = "src/cards/jack_of_diamonds2.png";
		cards[10][2] = "src/cards/jack_of_hearts2.png";
		cards[10][3] = "src/cards/jack_of_spades2.png";
		cards[11][0] = "src/cards/queen_of_clubs2.png";
		cards[11][1] = "src/cards/queen_of_diamonds2.png";
		cards[11][2] = "src/cards/queen_of_hearts2.png";
		cards[11][3] = "src/cards/queen_of_spades2.png";
		cards[12][0] = "src/cards/king_of_clubs2.png";
		cards[12][1] = "src/cards/king_of_diamonds2.png";
		cards[12][2] = "src/cards/king_of_hearts2.png";
		cards[12][3] = "src/cards/king_of_spades2.png";
	}
	
	private void initializeGUI() {
		
		score.setHorizontalAlignment(JTextField.CENTER);
		announcer.setHorizontalAlignment(JTextField.CENTER);
		
		score.setEditable(false);
		announcer.setEditable(false);

		BoxLayout bl = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(bl);
		
		ImageIcon imageIcon = new ImageIcon("src/cards/red_joker.png"); 
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(150, 210,  java.awt.Image.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(newimg));
		JPanel playerCard = new JPanel(new BorderLayout());
		
		ImageIcon imageIcon2 = new ImageIcon("src/cards/black_joker.png"); 
		Image image2 = imageIcon2.getImage();
		Image newimg2 = image2.getScaledInstance(150, 210,  java.awt.Image.SCALE_SMOOTH);
		JLabel label2 = new JLabel(new ImageIcon(newimg2));
		JPanel computerCard = new JPanel(new BorderLayout());
		
		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(2, 2, 10, 10);
		panel.setLayout(gridLayout);
		
		getContentPane().add(score);
		getContentPane().add(announcer);
		getContentPane().add(computerCard);
		getContentPane().add(playerCard);
		getContentPane().add(panel);
		
		computerCard.add( label, BorderLayout.CENTER );
		playerCard.add( label2, BorderLayout.CENTER );
		
		JButton cardButton = new JButton("New Cards");
		
		cardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				getContentPane().remove(computerCard);
				getContentPane().remove(playerCard);
				getContentPane().remove(panel);
				
				int i = ThreadLocalRandom.current().nextInt(0, 13);
				int j = ThreadLocalRandom.current().nextInt(0, 4);
				int k = ThreadLocalRandom.current().nextInt(0, 13);
				int l = ThreadLocalRandom.current().nextInt(0, 4);
				
				while(i == k && j == l) {
					i = ThreadLocalRandom.current().nextInt(0, 13);
					j = ThreadLocalRandom.current().nextInt(0, 4);
					k = ThreadLocalRandom.current().nextInt(0, 13);
					l = ThreadLocalRandom.current().nextInt(0, 4);
				}
				
				ImageIcon imageIcon3 = new ImageIcon(cards[i][j]);
				Image image3 = imageIcon3.getImage();
				Image newimg3 = image3.getScaledInstance(150, 210,  java.awt.Image.SCALE_SMOOTH);
				imageIcon3 = new ImageIcon(newimg3);
				//JLabel label3 = new JLabel("", imageIcon3, JLabel.CENTER);
				JPanel playerCard = new JPanel(new BorderLayout());
				label.setIcon(new ImageIcon(newimg3));
				
				ImageIcon imageIcon4 = new ImageIcon(cards[k][l]); 
				Image image4 = imageIcon4.getImage();
				Image newimg4 = image4.getScaledInstance(150, 210,  java.awt.Image.SCALE_SMOOTH);
				imageIcon4 = new ImageIcon(newimg4);
				//JLabel label4 = new JLabel("", imageIcon4, JLabel.CENTER);
				JPanel computerCard = new JPanel(new BorderLayout());
				label2.setIcon(new ImageIcon(newimg4));
				
				if(i>k) {
					playerScore += reward;
					announcer.setText("Player's card wins!");
					reward = 1;
				}
				else if(i<k) {
					computerScore += reward;
					announcer.setText("Computer's card wins!");
					reward = 1;
				}
				else if(i==k) {
					announcer.setText("A tie! Time for a war! The next round is worth three points.");
					reward = 3;
				}
				
				score.setText("Player: "+playerScore+" Computer: "+computerScore+"");
				
				int playerWinDiff = playerScore-computerScore;
				int computerWinDiff = computerScore-playerScore;
				
				if(playerScore >= 13) {
					score.setText("Player 1 wins by " + playerWinDiff + " points!");
					announcer.setText("Press the New Cards Button to play again!");
					playerScore = 0;
					computerScore = 0;
				}
				else if(computerScore >= 13) {
					score.setText("Computer wins by " + computerWinDiff + " points!");
					announcer.setText("Press the New Cards Button to play again!");
					playerScore = 0;
					computerScore = 0;
				}
				
				getContentPane().add(computerCard);
				getContentPane().add(playerCard);
				getContentPane().add(panel);
				
				playerCard.add( label, BorderLayout.CENTER );
				computerCard.add( label2, BorderLayout.CENTER );
				getContentPane().revalidate();
			}
		});
		panel.add(cardButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		panel.add(quitButton);
	       
		setTitle("War Card Game");
		setSize(450, 560);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	War calc = new War();
            	calc.setVisible(true);
            }
        });
    }

}
