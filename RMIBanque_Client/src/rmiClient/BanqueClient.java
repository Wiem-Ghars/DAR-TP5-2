package rmiClient;

import java.rmi.Naming;
import java.util.Date;

import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {
	public static void main(String[] args) {
        try {
        	// Recherche du service bancaire distant en utilisant le nom fourni lors de la liaison
            IBanque banque = (IBanque) Naming.lookup("rmi://localhost:1090/BanqueService");

            // Crée un nouveau compte avec un code, un solde, et une date de création spécifiques
            Compte nouveauCompte = new Compte(1, 190.6, new Date());

            // Appelle la méthode distante pour créer le compte et récupère le message de création
            String messageCreation = banque.creerCompte(nouveauCompte);
            System.out.println("Message de création de compte : " + messageCreation);

            int codeCompte = 1;

         // Appelle la méthode distante pour obtenir les informations du compte et affiche le résultat
            String infoCompte = banque.getInfoCompte(codeCompte);
            System.out.println("Information du compte : " + infoCompte);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
