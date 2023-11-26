package rmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmiService.BanqueImpl;

public class BanqueServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            // Création d'un registre RMI sur le port 1090
	            LocateRegistry.createRegistry(1090);

	            // Création d'une instance de l'implémentation du service bancaire
	            BanqueImpl bi = new BanqueImpl();

	            // Affichage des informations de l'objet BanqueImpl
	            System.out.println(bi.toString());

	            // Liaison de l'instance BanqueImpl au registre RMI BanqueService
	            Naming.rebind("rmi://localhost:1090/BanqueService", bi);

	            System.out.println("le serveur est en cours d'exécution ");
	        } catch (RemoteException | MalformedURLException e) {
	           
	        }

	}
}
