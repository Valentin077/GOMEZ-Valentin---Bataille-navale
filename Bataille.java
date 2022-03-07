import java.util.*;
import java.io.*;

/**
 * Ce programme cr�e automatiquement une partie de bataille navale 
 * et permet de jouer une partie contre un ordinateur.
 * <p>
 * Le jeu se fait sur une grille en 10 x 10 et chaque joueur
 * possede 5 bateau, un porte avions de 5 case, un croiseur de 4 cases
 * un contre-torpilleur de 3 cases, un sous-marin de 3 case et un
 * torpilleur de 2 cases.
 * 
 * @author 	valentin gomez
 * @version 1.0
 * @since 	1.0
 * 
 *
 */

public class Bataille {
	public static int [][]grilleOrdi = new int [10][10];
	public static int [][]grilleJoueur = new int [10][10];
	int NumLigne;
	int NumCol;
	int taille;
	int max = 10;
	int min = 1;
	enum Direction {
		HORIZONTALE,
		VERTICALE
	}
	public static Random random = new Random (); 
	
	public static int randRange(int min, int max){
		return random.nextInt(max - min)+ min;
		}
	
	/**
	 * Cette m�thode permet de v�rifier que l'endroit ou l'on
	 * veut placer notre bateau sur la grille est bien libre.
	 * 
	 * @param grille	Il s'agit de la grille dont on v�rifie possibilit� de placer le bateau
	 * @param l			Il s'agit de la ligne dans notre grille de jeu 
	 * @param c			Il s'agit de la colonne dans notre grille de jeu
	 * @param d 		Il s'agit de la direction dans laquel on veut placer le bateau dans la grille, donc soit HORIZONTALE ou VERTICALE
	 * @param t			Il s'agit du nombre de cases que fait le bateau
	 * @return			true si les cases ou on veut mettre notre bateau sont bien toutes libre
	 */
	
	public static boolean pos0k(int [][]grille, int l, int c, Direction d, int t) {
		int cmpt = 1;
		
		if (d = 'HORIZONTALE')
		{
			while (cmpt != t)
			{	
				if (grille[l][c] != 0 && l < 10 && c < 10)
				{
					return false;
					
				}
				else
				{
					cmpt +=1;
					l +=1;
				}
			}
			return true;
		else
		{
			while (cmpt != t)
			{	
				if (grille[l][c] != 0 && l < 10 && c < 10)
				{
					return false;
					
				}
				else
				{
					cmpt +=1;
					c +=1;
				}	
			}
			return true;
		}}
	}
	
	/**
	 * Cette m�thode permet d'initaliser les bateau sur
	 * la grille de l'ordinateur, elle appelera ma methode
	 * pos0k pour v�rifier l'emplacement que j'aurais al�atoirement
	 * choisi sur la grille.
	 * 
	 *  @since 1.0
	 * 
	 */
	
	public static void initGrilleOrdi()
	{
		int NbBatTr = 0;
		
		while (NbBatTr !=5)
		{
			
			while(pos0k(grilleOrdi, NumLigne, NumCol, Direction, taille) != false)
			{
				 NbBatTr += 1;
				// random.nextInt
			}
		}
	}
	
	/**
	 * Cette m�thode permet d'initialiser les bateau sur la grille 
	 * du joueur en m�thode de ce qu'il aura rentrer comme valeurs.
	 * J'apellerais encore une fois pos0k pour v�rifier si il est possible
	 * de placer les bateau au endroit demander par le joueur
	 * 
	 * @param l		Il s'agit de la ligne dans la grille choisi par le joueur pour placer sont bateau
	 * @param c 	Il s'agit de la colonne dans la grille choisi par le joueur pour placer sont bateau
	 * @param d		Il s'agit de la direction dans laquelle le joueur veut placer sont bateau, il peut �tre HORIZONTALE ou VERTICALE
	 * 
	 * @since 1.0
	 * 
	 */
		
	public static void initGrilleJeu (int l, String c, int d)
	{
		int i = 0;
		int tempoTaille;
		
		String[] bateau = {"porte-avions", "croiseur", "contre-torpilleur", "sous-marin", "torpilleur"};
		int[] BateauTaille = {5, 4, 3, 3, 2};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		while (i != 4)
		{
			tempoTaille = BateauTaille[i];
			
			System.out.println("Donnez la lettre pour le" + bateau[i]);
			String c.bateau[i] = br.readLine();
			System.out.println("Donnez le nombre pour le" + bateau[i]);
			int l.bateau[i] = Integer.parseInt(br.readLine());
			System.out.println("Voulez vous qu'il soit horizontal(1) ou verticale (2) ?");
			int d.bateau[i] = Integer.parseInt(br.readLine());
			
			byte bytes = c.getBytes("US-ASCII");
			byte Bytes = l.getBytes("US-ASCII");
		
			if (l < 1 || l >10 && c < 1 || l >10 && pos0k(grilleJoueur, l, c, d, tempoTaille) == true)
			{	
				if(d == 1)
				{
					for(int index = 0; index < tempoTaille; index++)
					{
						grilleJoueur[index + l][c] = BateauTaille[i];
					}
				else
				{
					for(int index = 0; index < tempoTaille; index++)
					{
						grilleJoueur[l][index + c] = BateauTaille[i];
					}
				}
				}
				
				i += 1;
			}	
			else
			
				System.out.println("Erreur : Le porte avions ne rentre pas dans la grille.");
			
				
		}
		
		
	
	}
	
	/**
	 * Cette m�thode permet de savoir si un bateau qui � �t� toucher
	 * aurait aussi �t� couler, et ne serait donc plus pr�sent sur la grille
	 * 
	 * @param grille	Il s'agit de la grille sur laquel je v�rifie si le bateau a �t� couler
	 * @param numBat	Il s'agit du num�ro du bateau qui correspond au type de bateau (sous-marin, torpilleurs...)
	 * @return			True si le bateau a �t� enti�rement couler et n'a donc plus de pr�sence sur la grille
	 * 
	 * @since 1.0
	 * 
	 */
	
	public static boolean couler (int[][] grille, int numBat)
	{
		
	}
		
	/**
	 * Cette m�thode permet de v�rifier, lorsque quelqun joue,
	 * si il on toucher un bateau adverse, si il on louper leur coups
	 * ou si il aurait couler le bateau adverse.
	 * 
	 * 
	 * @param grille	La grille du joueur qui est vis�e, et que l'on veut donc savoir si un bateau aurait �t� toucher
	 * @param l			Il s'agit de la ligne qui correspond a l'endroit ou le joueur a choisi de tirer
	 * @param c			Il s'agit de la colonne qui correspond a l'endroit ou le joueur a choisi de tirer
	 * 
	 * @since 1.0
	 */
	
	public static void mouvement (int[][] grille, int l, int c)
	{
		
	}
	
	/**
	 * 
	 * Cette m�thode se charge d'effectuer la tours de l'ordinateurs
	 * en choisissant des num�ro al�atoire pour effectuer ces coups.
	 * 
	 * @since	1.0
	 * 
	 */
	
	public static void tirOrdinateur()
	{
		
	}
	
	/**
	 * 
	 * Cette m�thode permet de d�terminer si tout les bateau d'une grille on �t� couler
	 * et permet de d�clarer un vainqueurs si lorsque il y en a un.
	 * 
	 * @param grille	Il s'agit de la grille que l'on test pour voir si tout les bateau dedans serait couler
	 * @return			True si tout les bateau d'une grille on �t� d�truit
	 * 
	 * @since			1.0
	 */
	
	public static boolean vainqueur(int[][] grille)
	{
		
	}
	
	/**
	 * Cette proc�dure est celle qui va faire fonctionner le jeu,
	 * elle apellera les autre fonction de mani�re a cr�er ma bataille navale
	 * 
	 */
	
	public static void engagement()
	{
		
	}
	
}
