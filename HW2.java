import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0544123 SHU LI YUN
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �������
	 * @param nDeck 蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}

class Deck{
	private ArrayList<Card> cards;
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int d=0;d<nDeck;d++)
		{
			for(int i=1;i<5;i++)
	        {
	        	for(int j=1;j<14;j++)
	        	{
	        		Card card=new Card(i,j);
	        		cards.add(card);
	        	}
	        }
		}//對於每一個Deck而言，都有4個suit與13個rank。將每一張新生成的card加到cards的ArrayList裡
	}
	public void printDeck(){
		for(int i=0;i<cards.size();i++)
		{
			
			Card card = new Card (cards.get(i).getSuit(),cards.get(i).getRank());
			//將每一張card的數值實體化
			card.printCard();
			//使用printCard將實體化後的card顯示在螢幕上
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}

class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}
	public void printCard(){
		if(suit==1)
			System.out.print("Clubs ");
		else if(suit==2)
			System.out.print("Diamonds ");
		else if(suit==3)
			System.out.print("Hearts ");
		else
			System.out.print("Spades ");
		if(rank==1)
			System.out.println("Ace");
		else
			System.out.println(rank);
		//如果suit=1就顯示Clubs，如果suit=2就顯示Diamonds，如果suit=3就顯示Hearts，如果suit=4就顯示Spades
		//如果rank=1就顯示Ace，否則顯示原來的數值
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
