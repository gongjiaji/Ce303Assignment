import java.util.*;

public class Game {
    private List<String> players;
    private final Map<InfluenceCard, Integer> cards;
    private final Map<String, Map<InfluenceCard,Integer>> playerCards;



    public Game() {
        players = new ArrayList<>();
        cards = new TreeMap<>();
        playerCards = new TreeMap<>();

        int playerID = 0;
        for (String player : Constants.PLAYERS){
            players.add(player);
            playerCards.put(player, new TreeMap<InfluenceCard,Integer>());
            for (int j = 0; j < Constants.PLAYERAMOUNT; j++) {
                playerID++;
                Player p = new Player(playerID, player);
//                cards.put(player, p);
//                customerAccounts.get(customer).add(account);
            }
        }
        System.out.println("Gamw Setup");
//        for (String customerId : customerAccounts.keySet()) {
//            System.out.println("### Customer " + customerId);
//            for (BankAccount bacc : customerAccounts.get(customerId)) {
//                System.out.println(bacc);
//            }
//        }
    }

    public List<String> getPlayers() {
        return Collections.unmodifiableList(players);
    }

//    public int[] getAccounts(String customer) {
//        if (!existsCustomer(customer))
//            return new int[] {};
//        int[] result = new int[customerAccounts.get(customer).size()];
//        int i = 0;
//        for (BankAccount acc : customerAccounts.get(customer)) {
//            result[i++] = acc.id;
//        }
//        return result;
//    }

//    public boolean existsCustomer(String playerID) {
//        return customerAccounts.containsKey(custId);
//    }

//    public boolean hasAccount(String custId, int accountNumber) {
//        for (BankAccount acc : customerAccounts.get(custId))
//            if (acc.id == accountNumber)
//                return true;
//        return false;
//    }
//
//    public boolean existsAccount(int accountNumber) {
//        return accounts.containsKey(accountNumber);
//    }
//
//    public Double getBalance(String custId, int accountNumber) {
//        if (!existsCustomer(custId) || !hasAccount(custId, accountNumber))
//            return null;
//        else
//            return accounts.get(accountNumber).getBalance();
//    }

//    public String transfer(String custId, int fromId, int toId, double amount) {
//        if (!existsCustomer(custId) || !hasAccount(custId, fromId) || !existsAccount(toId) || fromId == toId  || amount == 0)
//            return "Transfer failed: ("+custId+","+fromId+","+toId+","+amount+")";
//        BankAccount toAccount = accounts.get(toId);
//        BankAccount fromAccount = accounts.get(fromId);
//        synchronized(fromId < toId? fromAccount : toAccount) {
//            synchronized(fromId < toId? toAccount : fromAccount) {
//                fromAccount.transfer(toAccount, amount);
//                return "Transfer successful";
//            }
//        }
//    }
}
