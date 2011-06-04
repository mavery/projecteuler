package mavery.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mavery.projecteuler.util.FileUtils;

public class Problem54
{

	/**
	 * In the card game poker, a hand consists of five cards and are ranked,
	 * from lowest to highest, in the following way: High Card: Highest value
	 * card. One Pair: Two cards of the same value. Two Pairs: Two different
	 * pairs. Three of a Kind: Three cards of the same value. Straight: All
	 * cards are consecutive values. Flush: All cards of the same suit. Full
	 * House: Three of a kind and a pair. Four of a Kind: Four cards of the same
	 * value. Straight Flush: All cards are consecutive values of same suit.
	 * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
	 * 
	 * The cards are valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack,
	 * Queen, King, Ace.
	 * 
	 * If two players have the same ranked hands then the rank made up of the
	 * highest value wins; for example, a pair of eights beats a pair of fives
	 * (see example 1 below). But if two ranks tie, for example, both players
	 * have a pair of queens, then highest cards in each hand are compared (see
	 * example 4 below); if the highest cards tie then the next highest cards
	 * are compared, and so on.
	 * 
	 * Consider the following five hands dealt to two players:Hand Player 1
	 * Player 2 Winner 1 5H 5C 6S 7S KD Pair of Fives 2C 3S 8S 8D TD Pair of
	 * Eights Player 2 2 5D 8C 9S JS AC Highest card Ace 2C 5C 7D 8S QH Highest
	 * card Queen Player 1 3 2D 9C AS AH AC Three Aces 3D 6D 7D TD QD Flush with
	 * Diamonds Player 2 4 4D 6S 9H QH QC Pair of Queens Highest card Nine 3D 6D
	 * 7H QD QS Pair of Queens Highest card Seven Player 1 5 2H 2D 4C 4D 4S Full
	 * House With Three Fours 3C 3D 3S 9S 9D Full House with Three Threes Player
	 * 1
	 * 
	 * The file, poker.txt, contains one-thousand random hands dealt to two
	 * players. Each line of the file contains ten cards (separated by a single
	 * space): the first five are Player 1's cards and the last five are Player
	 * 2's cards. You can assume that all hands are valid (no invalid characters
	 * or repeated cards), each player's hand is in no specific order, and in
	 * each hand there is a clear winner.
	 * 
	 * How many hands does Player 1 win?
	 */
	public static void main(String[] args) throws Exception
	{
		System.out.println(new Problem54()
				.countWinners("resources/Problem54.txt"));
	}

	/**
	 * Counts the number of games of poker won by player 1 in the input file
	 * 
	 * @param filename
	 *            The file from which to get the game data
	 * @return the number of games won by player 1
	 * @throws Exception
	 *             if there was an error reading the file
	 */
	public int countWinners(String filename) throws Exception
	{
		int result = 0;
		for (String s : FileUtils.readLines(filename))
		{
			if (new Game(s).playerOneWins())
			{
				result++;
			}
		}

		return result;
	}

	private class Game
	{
		static final int HAND_SIZE = 5;

		Card[] playerOne;
		Card[] playerTwo;

		/**
		 * Creates a game with the cards specified in the input string
		 * 
		 * @param input
		 */
		Game(String input)
		{
			playerOne = new Card[HAND_SIZE];
			playerTwo = new Card[HAND_SIZE];

			String[] cards = input.split(" ");
			for (int i = 0; i < HAND_SIZE; i++)
			{
				playerOne[i] = new Card(cards[i]);
			}
			for (int i = 0; i < HAND_SIZE; i++)
			{
				playerTwo[i] = new Card(cards[i + HAND_SIZE]);
			}
		}

		/**
		 * Returns true if player 1 wins this game. False otherwise
		 * 
		 * @return True if player one wins, false if it is a tie or if player 2
		 *         wins.
		 */
		boolean playerOneWins()
		{
			Boolean result = null;
			if (result == null)
			{
				result = compare(straightFlush(playerOne),
						straightFlush(playerTwo));
			}
			if (result == null)
			{
				result = compare(fourOfAKind(playerOne), fourOfAKind(playerTwo));
			}
			if (result == null)
			{
				result = compare(fullHouse(playerOne), fullHouse(playerTwo));
			}
			if (result == null)
			{
				result = compare(flush(playerOne), flush(playerTwo));
			}
			if (result == null)
			{
				result = compare(straight(playerOne), straight(playerTwo));
			}
			if (result == null)
			{
				result = compare(threeOfAKind(playerOne),
						threeOfAKind(playerTwo));
			}
			if (result == null)
			{
				result = compare(twoPair(playerOne), twoPair(playerTwo));
			}
			if (result == null)
			{
				result = compare(pair(playerOne), pair(playerTwo));
			}
			if (result == null)
			{
				result = compare(highCard(playerOne), highCard(playerTwo));
			}

			return result;
		}

		private Boolean compare(List<Integer> p1, List<Integer> p2)
		{
			if (p1 == null && p2 == null)
			{
				return null;
			}
			if (p1 == null)
			{
				return false;
			}
			if (p2 == null)
			{
				return true;
			}
			for (int i = 0; i < p1.size(); i++)
			{
				if (p1.get(i) > p2.get(i))
				{
					return true;
				}
				if (p1.get(i) < p2.get(i))
				{
					return false;
				}
			}

			// p1 is not a winner in the event of a tie, although this shouldn't
			// be an issue here
			return false;
		}

		// this would be so much nicer if java had closures. i could use
		// anonymous inner classes to simulate that in an overly verbose way but
		// that's far too much for something like this

		// these will return null if the condition is not met and will return a
		// list of integers detailing the rank of the hand if it is valid

		// royal flush is just a max rank straight flush
		private List<Integer> straightFlush(Card[] hand)
		{
			if (flush(hand) != null)
			{
				return straight(hand);
			}

			return null;
		}

		private List<Integer> fourOfAKind(Card[] hand)
		{
			List<Integer> ranks = highCard(hand);
			if (ranks.get(0) == ranks.get(3) || ranks.get(1) == ranks.get(4))
			{
				List<Integer> result = new ArrayList<Integer>();
				result.add(ranks.get(1));
				result.add(ranks.get(ranks.get(0) == ranks.get(1) ? 4 : 0));
				return result;
			}
			return null;
		}

		private List<Integer> fullHouse(Card[] hand)
		{
			List<Integer> ranks = highCard(hand);
			if ((ranks.get(2) == ranks.get(0) && ranks.get(3) == ranks.get(4))
					|| (ranks.get(2) == ranks.get(4) && ranks.get(1) == ranks
							.get(0)))
			{
				List<Integer> result = new ArrayList<Integer>();
				result.add(ranks.get(2));
				result.add(ranks.get(ranks.get(2) == ranks.get(0) ? 4 : 0));
				return result;
			}

			return null;
		}

		private List<Integer> flush(Card[] hand)
		{
			for (int i = 1; i < hand.length; i++)
			{
				if (hand[0].suit != hand[i].suit)
				{
					return null;
				}
			}
			return highCard(hand);
		}

		private List<Integer> straight(Card[] hand)
		{
			List<Integer> ranks = highCard(hand);

			// aces can be used as either high or low in a straight.
			if (ranks.get(0) == 14 && ranks.get(1) == 5)
			{
				ranks.remove(0);
				ranks.add(1);
			}

			for (int i = 0; i < ranks.size() - 1; i++)
			{
				if (ranks.get(i) - 1 != ranks.get(i + 1))
				{
					return null;
				}
			}

			return ranks.subList(0, 1);
		}

		// don't call this if it's already a full house!
		private List<Integer> threeOfAKind(Card[] hand)
		{
			List<Integer> result = pair(hand);
			if (result == null)
			{
				return result;
			}

			for (int i = 1; i < result.size(); i++)
			{
				if (result.get(0) == result.get(i))
				{
					result.remove(i);
					return result;
				}
			}

			return null;
		}

		private List<Integer> twoPair(Card[] hand)
		{
			List<Integer> result = pair(hand);
			if (result == null)
			{
				return null;
			}
			for (int i = 1; i < result.size() - 1; i++)
			{
				if (result.get(i) == result.get(i + 1))
				{
					int pairRank = result.get(i);
					result.remove(i + 1);
					result.remove(i);
					result.add((pairRank > result.get(0) ? 0 : 1), pairRank);
					return result;
				}
			}

			return null;
		}

		private List<Integer> pair(Card[] hand)
		{
			List<Integer> result = highCard(hand);
			for (int i = 0; i < result.size() - 1; i++)
			{
				if (result.get(i) == result.get(i + 1))
				{
					int pairRank = result.get(i);
					result.remove(i + 1);
					result.remove(i);
					result.add(0, pairRank);
					return result;
				}
			}
			// no pair found
			return null;
		}

		// this is always valid and will always return a result
		private List<Integer> highCard(Card[] hand)
		{
			List<Integer> result = new ArrayList<Integer>();
			for (Card c : hand)
			{
				result.add(c.rank);
			}
			Collections.sort(result);
			Collections.reverse(result);
			return result;
		}
	}

	private class Card
	{
		int rank;
		char suit;

		Card(String s)
		{
			switch (s.charAt(0))
			{
			case 'A':
				rank = 14;
				break;
			case 'K':
				rank = 13;
				break;
			case 'Q':
				rank = 12;
				break;
			case 'J':
				rank = 11;
				break;
			case 'T':
				rank = 10;
				break;
			default:
				rank = Integer.parseInt(s.substring(0, 1));
			}

			this.suit = s.charAt(1);
		}

		public String toString()
		{
			return Integer.toString(rank) + Character.toString(suit);
		}
	}
}
