package codevita;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaiMiniProject {
      
      static class Transaction{
            
            String type;
            int amount;
            
            Transaction(String type, int amount){
                  this.type = type;
                  this.amount = amount;
            }
      }
      
      public static void main(String[] args){
            Scanner sc= new Scanner(System.in);
            
            int balance = sc.nextInt();
            int N = sc.nextInt();
            
            sc.nextLine();
            
            
            List<Transaction> transactions = new ArrayList<>();
            List<Integer> commits = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                  String line = sc.nextLine().trim();
                  String[] parts = line.split(" ");
                  
                  switch (parts[0]){
                        case "read":
                              System.out.println(balance);
                              break;
                              
                              
                        case "credit": {
                              int amt = Integer.parseInt(parts[1]);
                              balance += amt;
                              
                              transactions.add(new Transaction("credit", amt));
                              break;
                        }
                        
                        case "debit": {
                              int amt = Integer.parseInt(parts[1]);
                              balance -= amt;
                              
                              transactions.add(new Transaction("debit", amt));
                              break;
                        }
                        
                        case "abort":{
                              int idx = Integer.parseInt(parts[1]) -1;
                              
                              if (idx >= 0 && idx < transactions.size()) {
                                    Transaction t = transactions.get(idx);
                                    if (t.type.equals("credit")) balance -= t.amount;
                                    else balance += t.amount;
                                    transactions.remove(idx);
                              }
                              break;
                        }
                        
                        case"commit":{
                              commits.add(balance);
                              transactions.clear();
                              break;
                        }
                        
                        case "rollback":{
                              int commitIndex = Integer.parseInt(parts[1]) -1;
                              if(commitIndex >= 0 && commitIndex < commits.size()){
                                    balance = commits.get(commitIndex);
                                    transactions.clear();
                              }
                              break;
                        }
                        
                  }
            }
      }
}
