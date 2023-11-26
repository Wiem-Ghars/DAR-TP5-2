package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import metier.Compte;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {
	 private List<Compte> comptes;  

	    public BanqueImpl() throws RemoteException {
	        comptes = new ArrayList<>();
	    }
	   //Implementation des methodes de l'interface
	@Override
	//Ajout d'un compte à la liste des comptes
	public String creerCompte(Compte c) throws RemoteException {
		// TODO Auto-generated method stub
		 comptes.add(c);
	     return "Compte cree: "+c;
	}
	//Parcourir la liste des comptes pour trouver celui correspondant au code donné
	@Override
	public String getInfoCompte(int code) throws RemoteException {
		for (Compte compte : comptes) {
            if (compte.getCode() == code) {
                return "Code: " + compte.getCode() +
                        "\nSolde: " + compte.getSolde() +
                        "\nDate de création: " + compte.getDateCreation();
            }
        }
        return "Le compte avec le code"+code+"est introuvable.";
    }
}


